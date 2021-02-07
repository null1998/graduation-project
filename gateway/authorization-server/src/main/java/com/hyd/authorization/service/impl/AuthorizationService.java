package com.hyd.authorization.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hyd.authorization.service.IAuthorizationService;
import com.hyd.common.core.aop.CommonResponse;
import com.hyd.common.core.util.CommonResponseUtils;
import com.hyd.common.util.TokenUtil;
import jdk.nashorn.internal.ir.IfNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yanduohuang
 * @date 2021/2/7 14:08
 */
@Slf4j
@Service
public class AuthorizationService implements IAuthorizationService {
    @Autowired
    private RestTemplate restTemplate;
    public static final String URL = "http://user-center-server/user/center/role/permission/query/role/id/list";
    private static final String SECRET = "coisdcasdncajwe";
    @Override
    public CommonResponse<Object> authorization(String token, String url) {
        if (token == null || url == null) {
            CommonResponseUtils.failed("Internal Server Error");
        }
        Boolean valid = tokenValid(token);
        if (Boolean.TRUE.equals(valid)) {
            log.info("token合法"+token);
            // 分解token为header，playLoad，signature
            String[] split = token.split("\\.");
            JSONObject playLoad = JSON.parseObject(TokenUtil.decryptToken(split[1]).get(0));
            Long expiredTime = playLoad.getLong("exp");
            long currentTimeMillis = System.currentTimeMillis();
            if (!(expiredTime >= currentTimeMillis)) {
                JSONArray roleIdsJson = playLoad.getJSONArray("roleIdList");
                // HttpHeaders
                HttpHeaders requestHeaders = new HttpHeaders();
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
                requestBody.add("roleIdList", JSON.toJSONString(roleIdsJson));
                //HttpEntity
                HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(requestBody,requestHeaders);
                Object resp = restTemplate.postForObject(URL,requestEntity,Object.class);
                return null;
            }
            return CommonResponseUtils.failedWithMsg("50014","token过期");
        }
        return CommonResponseUtils.failedWithMsg("50008","token不合法");

    }
    /**
     * 验证token是否被篡改
     * @param token
     * @return
     */
    private Boolean tokenValid(String token) {
        if (token == null) {
            return false;
        }
        // 分解token为header，playLoad，signature
        String[] split = token.split("\\.");
        if (split.length == 3) {
            String encrypt = encrypt(split[0] + "." + split[1]);
            return encrypt.equals(TokenUtil.decryptToken(split[2]).get(0));
        }
        return false;
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
            keySeed = "abcd1234!@#$";// 默认种子
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
