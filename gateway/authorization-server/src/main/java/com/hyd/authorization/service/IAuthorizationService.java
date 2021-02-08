package com.hyd.authorization.service;

import com.hyd.common.core.aop.CommonResponse;

/**
 * @author yanduohuang
 * @date 2021/2/7 13:57
 */
public interface IAuthorizationService {
    /**
     * 授权
     * @param token
     * @param url
     * @param method
     * @return
     */
    CommonResponse<Object> authorization(String token, String url, String method);
}
