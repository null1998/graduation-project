package com.hyd.basedata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * 基础数据
 */
@EnableCaching
@SpringBootApplication
@ComponentScan("com.hyd.common")
@ComponentScan("com.hyd.basedata.dao")
@MapperScan(basePackages = {"com.hyd.basedata.dao"})
public class BaseDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseDataApplication.class, args);
    }
}
