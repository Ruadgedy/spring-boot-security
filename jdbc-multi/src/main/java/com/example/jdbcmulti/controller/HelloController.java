package com.example.jdbcmulti.controller;

import com.example.jdbcmulti.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
@RestController
public class HelloController {

    @Autowired
    @Qualifier("jdbcTemplateOne")
    JdbcTemplate jdbcTemplateOne;

    @Autowired
    @Qualifier("jdbcTemplateTwo")
    JdbcTemplate jdbcTemplateTwo;

    @GetMapping("/user")
    public List<User> getAllUsers(){
        final List<User> list = jdbcTemplateOne.query("select * from t_user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                final User user = new User();
                String username = resultSet.getString("name");
                String password = resultSet.getString("phone");
                user.setUsername(username);
                user.setPassword(password);
                return user;
            }
        });
        return list;
    }

    @GetMapping("/user2")
    public List<User> getAllUsers2(){
        final List<User> list = jdbcTemplateTwo.query("select * from t_user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                user.setPassword(password);
                user.setUsername(username);
                return user;
            }
        });
        return list;
    }
}
