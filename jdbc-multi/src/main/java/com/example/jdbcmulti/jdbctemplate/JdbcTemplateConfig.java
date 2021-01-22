package com.example.jdbcmulti.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
@Configuration
public class JdbcTemplateConfig {

    @Bean
    JdbcTemplate jdbcTemplateOne(@Autowired @Qualifier("dsOne") DataSource dsOne){
        return new JdbcTemplate(dsOne);
    }

    @Bean
    JdbcTemplate jdbcTemplateTwo(@Autowired @Qualifier("dsTwo") DataSource dsTwo){
        return new JdbcTemplate(dsTwo);
    }
}
