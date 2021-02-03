package com.hyd.user.center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yanduohuang
 * @date 2021/2/3 15:51
 */
@SpringBootApplication
@ComponentScan("com.sd365.common")
@ComponentScan("com.sd365.common.api.version")
@ComponentScan("com.hyd.user.center.dao")
@MapperScan(basePackages = {"com.hyd.user.center.dao"})
public class UserCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }
}
