package com.hyd.authentication.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hyd.authentication.service.IAuthenticationService;

import com.hyd.common.core.aop.CommonResponse;
import com.hyd.common.core.util.CommonResponseUtils;
import com.hyd.common.util.AESUtil;
import com.hyd.common.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;
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

    private static Long ACCESS_TOKEN_LIFE_CYCLE_MILLI = 30*1000L;
    private static Long REFRESH_TOKEN_LIFE_CYCLE_MILLI = 30*60*1000L;
    public static final String URL = "http://user-center-server/user/center/user/login?username=%s&password=%s";
    @Override
    public CommonResponse<Object> authenticate(String username, String password) {
        if (username == null || password == null) {
            return CommonResponseUtils.failed("Internal Server Error");
        }
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
                    // 使用账户为键，将refresh token存储在redis中,有效期为2小时
                    redisTemplate.opsForValue().set(username, TokenUtil.encoderToken(header.toJSONString(),payload.toJSONString()),REFRESH_TOKEN_LIFE_CYCLE_MILLI,TimeUnit.MILLISECONDS);

                    // 设置access token有效期为30秒
                    long currentTimeMillis = System.currentTimeMillis();
                    payload.put("exp",currentTimeMillis+ACCESS_TOKEN_LIFE_CYCLE_MILLI);
                    // 加密头部和负载生成签名
                    String signature = TokenUtil.encoderToken(AESUtil.encrypt(TokenUtil.encoderToken(header.toJSONString(),payload.toJSONString())));
                    // 生成access token
                    String accessToken = TokenUtil.encoderToken(header.toJSONString(),payload.toJSONString())+"."+signature;
                    log.info(username+"认证成功");
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
            log.info(String.format("旧token的时间戳%d",playLoad.getLong("exp")));
            Object refreshToken = redisTemplate.opsForValue().get(username);
            if (refreshToken != null) {
                // 验证refreshToken 没有过期
                long currentTimeMillis = System.currentTimeMillis();
                // 重新设置access token过期时间
                playLoad.put("exp", currentTimeMillis+ACCESS_TOKEN_LIFE_CYCLE_MILLI);
                log.info(String.format("新token的时间戳%d",playLoad.getLong("exp")));
                String header = TokenUtil.decryptToken(split[0]).get(0);
                // 重新生成签名
                String signature = TokenUtil.encoderToken(AESUtil.encrypt(TokenUtil.encoderToken(header,playLoad.toJSONString())));
                // 生成access token
                String accessToken = TokenUtil.encoderToken(header, playLoad.toJSONString()) + "." + signature;
                log.info(username+"刷新token成功");
                return CommonResponseUtils.successWithToken(accessToken);
            }
        }
        log.info(expiredToken+"刷新token失败");
        return CommonResponseUtils.failedWithMsg("50008","重新登录");
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
            log.info(username+"禁用token成功");
            return CommonResponseUtils.success();
        }
        log.info(expiredToken+"禁用token失败");
        return CommonResponseUtils.failedWithMsg("50009","禁用token失败");
    }
}
