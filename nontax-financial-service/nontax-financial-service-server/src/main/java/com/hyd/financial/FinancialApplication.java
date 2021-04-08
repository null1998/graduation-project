package com.hyd.financial;

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
 * @author yanduohuang
 * @date 2021/2/1 17:45
 */
@Slf4j
@EnableCaching
@SpringBootApplication
@ComponentScan("com.hyd.common")
@ComponentScan("com.hyd.financial.dao")
@ComponentScan("com.hyd.basedata.service")
@MapperScan(basePackages = {"com.hyd.financial.dao","com.hyd.basedata.dao"})
public class FinancialApplication implements CommandLineRunner {
    @Autowired
    private DataSource dataSource;
    public static void main(String[] args) {
        SpringApplication.run(FinancialApplication.class, args);
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
