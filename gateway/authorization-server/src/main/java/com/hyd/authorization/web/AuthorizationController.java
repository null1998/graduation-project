package com.hyd.authorization.web;

import com.hyd.authorization.service.IAuthorizationService;
import com.hyd.common.core.aop.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yanduohuang
 * @date 2021/2/7 13:57
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/authorization")
public class AuthorizationController {
    @Autowired
    private IAuthorizationService authorizationService;
    @GetMapping
    public CommonResponse<Object> authorization(@RequestParam String token, @RequestParam String url, @RequestParam String method) {
        return authorizationService.authorization(token, url, method);
    }
}
