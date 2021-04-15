package com.hyd.basedata;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 基础数据
 */
@Slf4j
@EnableCaching
@SpringBootApplication
@ComponentScan("com.hyd.common")
@ComponentScan("com.hyd.basedata.dao")
@MapperScan(basePackages = {"com.hyd.basedata.dao"})
public class BaseDataApplication implements CommandLineRunner {
    @Autowired
    private DataSource dataSource;
    public static void main(String[] args) {
        SpringApplication.run(BaseDataApplication.class, args);
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
