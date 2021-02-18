package com.hyd.financial;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yanduohuang
 * @date 2021/2/1 17:45
 */
@SpringBootApplication
@ComponentScan("com.hyd.common")
@ComponentScan("com.hyd.financial.dao")
@ComponentScan("com.hyd.basedata.service")
@MapperScan(basePackages = {"com.hyd.financial.dao","com.hyd.basedata.dao"})
public class FinancialApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinancialApplication.class, args);
    }
}
