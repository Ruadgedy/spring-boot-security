package com.example.mybatis.service;

import com.example.mybatis.entity.User;
import com.example.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
public interface UserService {
    List<User> getAllUsers();

    User getUserById(String id);

    void addUser(User user);

    void updateUserById(User user);

    Integer deleteUserById(String id);
}
