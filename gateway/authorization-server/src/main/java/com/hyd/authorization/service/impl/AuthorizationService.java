package com.hyd.authorization.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hyd.authorization.service.IAuthorizationService;
import com.hyd.common.core.aop.CommonResponse;
import com.hyd.common.core.util.CommonResponseUtils;
import com.hyd.common.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
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
        if (token == null || url == null) {
            CommonResponseUtils.failed("Internal Server Error");
        }
        if (TokenUtil.tokenValid(token)) {
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
                        log.info("刷新token成功");
                        // 负载更新
                        playLoad = JSON.parseObject(TokenUtil.decryptToken(token.split("\\.")[1]).get(0));
                    } else {
                        log.info("重新登录");
                        return CommonResponseUtils.failedWithMsg("50008","重新登录");
                    }
                }
            }
            // 取出该用户角色列表
            JSONArray roleIdsJson = playLoad.getJSONArray("roleIdList");
            // 查找出该用户的所有角色的所有权限
            List<Permission> permissionList = listPermission(roleIdsJson);
            // 一一判断直到判断出是否有对应权限
            boolean authorizationResult = authorizationResult(permissionList, url, method);
            log.info(String.format("%s---%s鉴权结果%s",method,url,authorizationResult));
            // 每次鉴权后把token放在head中，方便前端更新
            return authorizationResult ? CommonResponseUtils.successWithToken(token) : CommonResponseUtils.failedWithMsg("50000","没有权限");
        }
        log.info("重新登录");
        // 不合法
        return CommonResponseUtils.failedWithMsg("50008","重新登录");

    }
    private static class Permission {

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
        ArrayList<Permission> permissions = new ArrayList<>();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<Long>> requestEntity = new HttpEntity(roleIdList,requestHeaders);
        JSONObject resp = restTemplate.postForObject(URL,requestEntity,JSONObject.class);
        if (resp != null) {
            JSONObject body = resp.getJSONObject("body");
            if (body != null) {
                // 查询与角色关联的权限
                JSONArray rolePermissionList = body.getJSONArray("data");
                for (int i = 0; i < rolePermissionList.size(); i++) {
                    JSONObject rolePermission = rolePermissionList.getJSONObject(i);
                    Long permissionId = rolePermission.getLong("permissionId");
                    // 查询该权限详细信息
                    JSONObject respPermission = restTemplate.getForObject(String.format(URL_PERMISSION, permissionId), JSONObject.class);
                    if (respPermission != null && respPermission.getJSONObject("body") != null) {
                        String method = respPermission.getJSONObject("body").getString("method");
                        String url = respPermission.getJSONObject("body").getString("url");
                        Permission permission = new Permission(url,method);
                        permissions.add(permission);
                    }
                }
            }
        }
        return permissions;
    }
    private boolean authorizationResult(List<Permission> permissionList, String url, String method) {
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




}
