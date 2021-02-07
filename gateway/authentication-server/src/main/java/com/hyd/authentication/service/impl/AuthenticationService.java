package com.hyd.authentication.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hyd.authentication.service.IAuthenticationService;

import com.hyd.common.core.aop.CommonResponse;
import com.hyd.common.core.util.CommonResponseUtils;
import com.hyd.common.util.TokenUtil;
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
@Service
public class AuthenticationService implements IAuthenticationService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String SECRET = "coisdcasdncajwe";

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
            JSONObject body = json.getJSONObject("body");
            if (body.getLong("id") != null) {
                // 构建头
                JSONObject header = new JSONObject();
                header.put("alg","AES");
                header.put("typ","JWT");
                // 构建负载
                JSONObject payload = new JSONObject();
                payload.put("username", username);
                payload.put("userId", body.getLong("id"));
                payload.put("unitId", body.getLong("unitId"));
                payload.put("roleIdList",body.getJSONArray("roleIdList"));
                // 使用账户为键，将refresh token存储在redis中,有效期为2小时
                redisTemplate.opsForValue().set(username, TokenUtil.encoderToken(header.toJSONString(),payload.toJSONString()),2, TimeUnit.HOURS);

                // 设置access token有效期为30秒
                long currentTimeMillis = System.currentTimeMillis();
                payload.put("exp",currentTimeMillis+0.5*60*1000);
                // 加密头部和负载生成签名
                String signature = TokenUtil.encoderToken(encrypt(TokenUtil.encoderToken(header.toJSONString(),payload.toJSONString())));
                // 生成access token
                String accessToken = TokenUtil.encoderToken(header.toJSONString(),payload.toJSONString())+"."+signature;
                body.put("accessToken",accessToken);
                return CommonResponseUtils.success(body);
            }
        } catch (RestClientException e) {
            return CommonResponseUtils.failed(e.getMessage());
        }
        return CommonResponseUtils.failed("Internal Server Error");
    }

    @Override
    public CommonResponse<Object> refreshToken(String expiredToken) {
        return null;
    }

    @Override
    public CommonResponse<Object> disableToken(String username) {
        return null;
    }
    /**
     * 根据密钥对指定的明文plainText进行加密.
     *
     * @param plainText 明文
     * @return 加密后的密文.
     */
    public static String encrypt(String plainText) {
        Key secretKey = getKey(SECRET);
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] p = plainText.getBytes(StandardCharsets.UTF_8);
            byte[] result = cipher.doFinal(p);
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Key getKey(String keySeed) {
        if (keySeed == null) {
            keySeed = System.getenv("AES_SYS_KEY");
        }
        if (keySeed == null) {
            keySeed = System.getProperty("AES_SYS_KEY");
        }
        if (keySeed == null || keySeed.trim().length() == 0) {
            keySeed = "abcd1234!@#$";
        }
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(keySeed.getBytes());
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(secureRandom);
            return generator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
