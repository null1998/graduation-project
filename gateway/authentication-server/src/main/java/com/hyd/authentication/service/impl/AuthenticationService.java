package com.hyd.authentication.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hyd.authentication.service.IAuthenticationService;

import com.hyd.common.core.aop.CommonResponse;
import com.hyd.common.core.util.CommonResponseUtils;
import com.hyd.common.util.AESUtil;
import com.hyd.common.util.TimeUtil;
import com.hyd.common.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.security.Permission;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yanduohuang
 * @date 2021/2/7 9:37
 */
@Slf4j
@Service
public class AuthenticationService implements IAuthenticationService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    private static Long ACCESS_TOKEN_LIFE_CYCLE_MILLI = 5*60*1000L;
    private static Long REFRESH_TOKEN_LIFE_CYCLE_MILLI = 30*60*1000L;
    public static final String URL = "http://user-center-server/user/center/user/login?username=%s&password=%s";
    class Permission{
        private String url;
        private String method;

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

        public Permission(String url, String method) {
            this.url = url;
            this.method = method;
        }
    }
    @Override
    public CommonResponse<Object> authenticate(String username, String password) {
        if (username == null || password == null) {
            return CommonResponseUtils.failed("Internal Server Error");
        }
        long time0 = System.currentTimeMillis();
        String format = String.format(URL, username, password);

        try {
            Object resp = restTemplate.getForObject(format, Object.class);
            JSONObject json = (JSONObject) JSON.toJSON(resp);
            if (json != null && json.getJSONObject("body") != null) {
                JSONObject body = json.getJSONObject("body");
                if (body.getJSONObject("data") != null && body.getJSONObject("data").getLong("id") != null) {
                    JSONObject data = body.getJSONObject("data");
                    // 构建头
                    JSONObject header = new JSONObject();
                    header.put("alg","AES");
                    header.put("typ","JWT");
                    // 构建负载
                    JSONObject payload = new JSONObject();
                    payload.put("username", username);
                    payload.put("userId", data.getLong("id"));
                    payload.put("unitId", data.getLong("unitId"));
                    payload.put("roleIdList",data.getJSONArray("roleIdList"));
                    payload.put("permissionIdList",data.getJSONArray("permissionIdList"));
                    // 使用账户为键，将refresh token存储在redis中
                    redisTemplate.opsForValue().set(username, TokenUtil.encoderToken(header.toJSONString(),payload.toJSONString()),REFRESH_TOKEN_LIFE_CYCLE_MILLI,TimeUnit.MILLISECONDS);

                    // 设置access token有效期
                    long currentTimeMillis = System.currentTimeMillis();
                    payload.put("exp",currentTimeMillis+ACCESS_TOKEN_LIFE_CYCLE_MILLI);
                    // 加密头部和负载生成签名
                    String signature = TokenUtil.encoderToken(AESUtil.encrypt(TokenUtil.encoderToken(header.toJSONString(),payload.toJSONString())));
                    // 生成access token
                    String accessToken = TokenUtil.encoderToken(header.toJSONString(),payload.toJSONString())+"."+signature;
                    JSONObject parseToken = TokenUtil.parseToken(accessToken);
//                    log.info("\n===>用户["+username+"]认证成功"
//                            +"\n===>解析的token"+parseToken.toJSONString()
//                            +"\n===>有效期至"+ TimeUtil.getDateTimeOfTimestamp(currentTimeMillis+ACCESS_TOKEN_LIFE_CYCLE_MILLI).toString()
//                            +"\n===>最长有效期至"+ TimeUtil.getDateTimeOfTimestamp(currentTimeMillis+REFRESH_TOKEN_LIFE_CYCLE_MILLI).toString()
//                            +"\n===>生成的token"+accessToken);
                    long time1 = System.currentTimeMillis();
                    log.info(username+"认证耗时"+(time1-time0)+"ms");
                    return CommonResponseUtils.success(accessToken,data);
                }
            }
        } catch (RestClientException e) {
            return CommonResponseUtils.failed(e.getMessage());
        }
        return CommonResponseUtils.failed("Internal Server Error");
    }

    @Override
    public CommonResponse<Object> refreshToken(String expiredToken) {
        if (TokenUtil.tokenValid(expiredToken)) {
            // 首先验证已过期token是否合法
            String[] split = expiredToken.split("\\.");
            // 取出负载
            JSONObject playLoad = JSON.parseObject(TokenUtil.decryptToken(split[1]).get(0));
            String username = playLoad.getString("username");
            //log.info(String.format("\n===>旧token有效期至%s",TimeUtil.getDateTimeOfTimestamp(playLoad.getLong("exp"))));
            Object refreshToken = redisTemplate.opsForValue().get(username);
            if (refreshToken != null) {
                // 验证refreshToken 没有过期
                long currentTimeMillis = System.currentTimeMillis();
                // 重新设置access token过期时间
                playLoad.put("exp", currentTimeMillis+ACCESS_TOKEN_LIFE_CYCLE_MILLI);
                String header = TokenUtil.decryptToken(split[0]).get(0);
                // 重新生成签名
                String signature = TokenUtil.encoderToken(AESUtil.encrypt(TokenUtil.encoderToken(header,playLoad.toJSONString())));
                // 生成access token
                String accessToken = TokenUtil.encoderToken(header, playLoad.toJSONString()) + "." + signature;
                JSONObject parseToken = TokenUtil.parseToken(accessToken);
//                log.info("\n===>用户["+username+"]刷新成功"
//                        +"\n===>解析的token"+parseToken.toJSONString()
//                        +"\n===>有效期至"+ TimeUtil.getDateTimeOfTimestamp(currentTimeMillis+ACCESS_TOKEN_LIFE_CYCLE_MILLI).toString()
//                        +"\n===>生成的token"+accessToken);
                return CommonResponseUtils.successWithToken(accessToken);
            }
            //log.info("\n===>重新登录[刷新token失败，token已过期]");
            return CommonResponseUtils.failedWithMsg("50008","[刷新token失败，token已过期]");
        }
        //log.info("\n===>重新登录[刷新token失败，token不合法]");
        return CommonResponseUtils.failedWithMsg("50008","重新登录[刷新token失败，token不合法]");
    }

    @Override
    public CommonResponse<Object> disableToken(String expiredToken) {
        if (TokenUtil.tokenValid(expiredToken)) {
            // 首先验证已过期token是否合法
            String[] split = expiredToken.split("\\.");
            // 取出负载
            JSONObject playLoad = JSON.parseObject(TokenUtil.decryptToken(split[1]).get(0));
            String username = playLoad.getString("username");
            Object refreshToken = redisTemplate.opsForValue().get(username);
            if (refreshToken != null) {
                redisTemplate.delete(username);
            }
            //log.info("\n===>用户["+username+"]禁用token成功");
            return CommonResponseUtils.success();
        }
        //log.info("\n===>禁用token失败，token不合法");
        return CommonResponseUtils.failedWithMsg("50009","禁用token失败[token不合法]");
    }
}
