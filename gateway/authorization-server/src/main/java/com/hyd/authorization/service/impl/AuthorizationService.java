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
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.Permission;
import java.security.SecureRandom;
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
    public static final String URL = "http://user-center-server/user/center/role/permission/query/role/id/list";
    public static final String URL_PERMISSION = "http://user-center-server/user/center/permission/%d";
    private static final String SECRET = "coisdcasdncajwe";
    @Override
    public CommonResponse<Object> authorization(String token, String url, String method) {
        if (token == null || url == null) {
            CommonResponseUtils.failed("Internal Server Error");
        }
        Boolean valid = tokenValid(token);
        if (Boolean.TRUE.equals(valid)) {
            // token合法
            // 分解token为header，playLoad，signature
            String[] split = token.split("\\.");
            // 取出负载
            JSONObject playLoad = JSON.parseObject(TokenUtil.decryptToken(split[1]).get(0));
            // 取出过期时间
            Long expiredTime = playLoad.getLong("exp");
            long currentTimeMillis = System.currentTimeMillis();
            if (!(expiredTime >= currentTimeMillis)) {
                // 没有过期则开始查询权限
                JSONArray roleIdsJson = playLoad.getJSONArray("roleIdList");
                // 查找出该用户的所有权限
                List<Permission> permissionList = listPermission(roleIdsJson);
                // 一一判断直到找到结果
                boolean authorizationResult = authorizationResult(permissionList, url, method);
                return authorizationResult ? CommonResponseUtils.success() : CommonResponseUtils.failedWithMsg("50000","没有权限");
            }
            // 已过期
            return CommonResponseUtils.failedWithMsg("50014","token过期");
        }
        // 不合法
        return CommonResponseUtils.failedWithMsg("50008","token不合法");

    }
    private class Permission {


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
                if (matcher.find()) {
                    return Objects.equals(permission.getUrl(), matcher.group(1));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String url = "http://127.0.0.1:8091/user/center/permission/list?assax=1";
        final Pattern compile = compile("^https?:\\/\\/(?:[a-zA-Z0-9\\.:]*)([a-zA-Z\\/]*)(?:\\??[0-9]*)");
        Matcher matcher = compile.matcher(url);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
        }
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
