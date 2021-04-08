package com.hyd.authorization.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.hyd.authorization.service.IAuthorizationService;
import com.hyd.common.core.aop.CommonResponse;
import com.hyd.common.core.util.CommonResponseUtils;
import com.hyd.common.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.*;
/**
 * @author yanduohuang
 * @date 2021/2/7 14:08
 */
@Slf4j
@Service
public class AuthorizationService implements IAuthorizationService {
    @Autowired
    private RestTemplate restTemplate;
    private static final String URL = "http://user-center-server/user/center/role/permission/query/role/id/list";
    private static final String URL_PERMISSION = "http://user-center-server/user/center/permission/%d";
    private static final String URL_REFRESH_TOKEN = "http://authentication-server/authenticate/refresh?expiredToken=%s";
    @Override
    public CommonResponse<Object> authorization(String token, String url, String method) {
        if (token == null || StringUtils.equals(token,"null") || url == null) {
            return CommonResponseUtils.failed("Internal Server Error");
        }
        log.info(String.format("\n===>请求接口%s %s",method,url)+"\n===>待校验token"+token);
        long time00 = System.currentTimeMillis();
        if (TokenUtil.tokenValid(token)) {
            long time01 = System.currentTimeMillis();
            log.info("["+method+"]"+url+"验证token合法性"+(time01-time00)+"ms");
            // token合法
            // 分解token为header，playLoad，signature
            String[] split = token.split("\\.");
            // 取出负载
            JSONObject playLoad = JSON.parseObject(TokenUtil.decryptToken(split[1]).get(0));
            // 取出过期时间
            Long expiredTime = playLoad.getLong("exp");
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis > expiredTime) {
                // 过期则尝试刷新token
                JSONObject resp = restTemplate.getForObject(String.format(URL_REFRESH_TOKEN, token), JSONObject.class);
                if (resp != null && resp.getJSONObject("head") != null) {
                    Integer code = resp.getJSONObject("head").getInteger("code");
                    // 新的token
                    token = resp.getJSONObject("head").getString("accessToken");
                    if (code == 0 && token != null && TokenUtil.tokenValid(token)) {
                        // 刷新成功
                        // 负载更新
                        playLoad = JSON.parseObject(TokenUtil.decryptToken(token.split("\\.")[1]).get(0));
                    } else {
                        log.info("\n===>重新登录[刷新token失败]");
                        return CommonResponseUtils.failedWithMsg("50008","重新登录[刷新token失败]");
                    }
                }
            }
            // 取出该用户角色列表
            JSONArray roleIdsJson = playLoad.getJSONArray("roleIdList");
            long time2 = System.currentTimeMillis();
            // 查找出该用户的所有角色的所有权限
            List<Permission> permissionList = listPermission(roleIdsJson);
            long time3 = System.currentTimeMillis();
            log.info("["+method+"]"+url+"查找出该用户的所有角色的所有权限"+(time3-time2)+"ms");
            // 一一判断直到判断出是否有对应权限
            boolean authorizationResult = authorizationResult(permissionList, url, method);
            long time4 = System.currentTimeMillis();
            log.info("["+method+"]"+url+"一一判断直到判断出是否有对应权限"+(time4-time3)+"ms");
            log.info(String.format("\n===>请求接口%s %s",method,url)+"\n===>鉴权结果"+authorizationResult);
            // 每次鉴权后把token放在head中，方便前端更新
            long time5 = System.currentTimeMillis();
            log.info("["+method+"]"+url+"鉴权时长"+(time5-time00)+"ms");
            return authorizationResult ? CommonResponseUtils.successWithToken(token) : CommonResponseUtils.failedWithMsg("50000","没有权限");
        }
        log.info("\n===>重新登录[token不合法]"+"\n===>尝试解析不合法token"+TokenUtil.parseToken(token).toJSONString());
        // 不合法
        return CommonResponseUtils.failedWithMsg("50008","重新登录[token不合法]");

    }
    public static class Permission {

        private String url;

        private String method;

        public Permission(String url, String method) {
            this.url = url;
            this.method = method;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }
    }

    /**
     * 根据角色id列表查询所有的权限
     * @param roleIdList 角色id列表
     * @return 权限列表
     */
    private List<Permission> listPermission(JSONArray roleIdList) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<Long>> requestEntity = new HttpEntity(roleIdList,requestHeaders);
        long time1 = System.currentTimeMillis();
        JSONObject resp = restTemplate.postForObject(URL,requestEntity,JSONObject.class);
        long time2 = System.currentTimeMillis();
        log.info("查找用户的用户权限列表花费"+(time2-time1)+"ms");
        if (resp != null && resp.getJSONObject("body") != null) {
            JSONArray permissionList = resp.getJSONObject("body").getJSONArray("data");
            return permissionList.toJavaList(Permission.class);
        }
        return new ArrayList<>();
    }
    private boolean authorizationResult(List<Permission> permissionList, String url, String method) {
        if (!whiteList(url,method)) {
            // 如果不在白名单中，则开始鉴权
            for (Permission permission : permissionList) {
                if (Objects.equals(permission.getMethod(), method)) {
                    final Pattern compile = compile("^https?:\\/\\/(?:[a-zA-Z0-9\\.:]*)([a-zA-Z\\/]*)(?:\\??[0-9]*)");
                    Matcher matcher = compile.matcher(url);
                    if (matcher.find() && Objects.equals(permission.getUrl(), matcher.group(1))) {
                        return true;
                    }
                }
            }
            return false;
        }

        return true;
    }

    /**
     * 白名单，部分api可以开放给所有角色，无需鉴权
     * @param url
     * @param method
     * @return
     */
    private boolean whiteList(String url, String method) {
        if (Objects.equals(method,"GET") && url != null && url.contains("/nontax/basedata")) {
            // 查询基础数据都放行
            return true;
        }
        if (Objects.equals(method, "GET") && url != null && url.contains("/user/center/user/info")) {
            // 查询用户信息的放行
            return true;
        }
        return false;
    }



}
