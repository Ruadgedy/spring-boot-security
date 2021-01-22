package com.example.mybatis.service;

import com.example.mybatis.entity.User;
import com.example.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuhao
 * @date: 2021/1/22
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }

    @Override
    public Integer deleteUserById(String id) {
        return userMapper.deleteUserById(id);
    }
}
