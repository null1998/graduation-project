package com.hyd.user.center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yanduohuang
 * @date 2021/2/3 15:51
 */
@EnableCaching
@SpringBootApplication
@ComponentScan("com.hyd.common")
@ComponentScan("com.hyd.user.center.dao")
@ComponentScan("com.hyd.basedata")
@MapperScan(basePackages = {"com.hyd.user.center.dao"})
public class UserCenterApplication {
    private static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(UserCenterApplication.class, args);
        displayAllBeans();
    }
    public static void displayAllBeans() {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            if (beanName.contains("Aspect")) {
                System.out.println(beanName);
            }
        }
    }
}
