package com.hyd.authentication.web;

import com.hyd.authentication.service.IAuthenticationService;
import com.hyd.common.core.aop.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yanduohuang
 * @date 2021/2/7 9:24
 */
@CrossOrigin
@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
    @Autowired
    private IAuthenticationService authenticationService;

    /**
     * 认证
     * @param username 用户名
     * @param password 密码
     * @return 认证成功返回token
     */
    @GetMapping
    public CommonResponse<Object> authenticate(@RequestParam String username, @RequestParam String password) {
        return authenticationService.authenticate(username, password);
    }

    /**
     * 刷新token
     * @param expiredToken 过期token
     * @return 刷新成功返回新token
     */
    @GetMapping("/refresh")
    public CommonResponse<Object> refreshToken(@RequestParam String expiredToken) {
        return authenticationService.refreshToken(expiredToken);
    }

    /**
     * 禁用token
     * @param token
     * @return
     */
    @DeleteMapping("/disable")
    public CommonResponse<Object> disableToken(@RequestHeader(name="accessToken") String token) {
        return authenticationService.disableToken(token);
    }

}
