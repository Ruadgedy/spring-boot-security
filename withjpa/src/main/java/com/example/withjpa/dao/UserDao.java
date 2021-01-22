package com.example.withjpa.dao;

import com.example.withjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yuhao
 * @date: 2021/1/19
 * @description:
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
