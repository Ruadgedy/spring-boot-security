package com.example.rediscache.service;

import com.example.rediscache.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
public interface UserService {
    User save(User user);

    User get(Integer id);

    void delete(Integer id);
}
