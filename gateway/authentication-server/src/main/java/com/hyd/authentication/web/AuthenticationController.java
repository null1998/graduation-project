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
    @GetMapping
    public CommonResponse<Object> authenticate(@RequestParam String username, @RequestParam String password) {
        return authenticationService.authenticate(username, password);
    }
}
