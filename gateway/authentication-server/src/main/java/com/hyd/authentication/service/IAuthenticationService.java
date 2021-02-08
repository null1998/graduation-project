package com.hyd.authentication.service;


import com.hyd.common.core.aop.CommonResponse;

/**
 * @author yanduohuang
 * @date 2021/2/7 9:31
 */
public interface IAuthenticationService {
    /**
     * 认证
     * @param username 用户名
     * @param password 密码
     * @return
     */
    CommonResponse<Object> authenticate(String username, String password);

    /**
     * 刷新token
     * @param expiredToken 过期token
     * @return
     */
    CommonResponse<Object> refreshToken(String expiredToken);

    /**
     * 禁用token
     * @param token
     * @return
     */
    CommonResponse<Object> disableToken(String token);
}
