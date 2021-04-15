package com.hyd.user.center;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author yanduohuang
 * @date 2021/2/3 15:51
 */
@Slf4j
@EnableCaching
@SpringBootApplication
@ComponentScan("com.hyd.common")
@ComponentScan("com.hyd.user.center.dao")
@ComponentScan("com.hyd.basedata")
@MapperScan(basePackages = {"com.hyd.user.center.dao"})
public class UserCenterApplication implements CommandLineRunner {
    @Autowired
    private DataSource dataSource;
    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            // 这里，可以做点什么
            log.info("[run][获得连接：{}]", conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
