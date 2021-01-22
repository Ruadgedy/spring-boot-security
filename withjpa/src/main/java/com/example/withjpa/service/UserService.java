package com.example.withjpa.service;

import com.example.withjpa.dao.UserDao;
import com.example.withjpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author yuhao
 * @date: 2021/1/19
 * @description:
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userDao.findUserByUsername(username);
        if (user == null){
            throw  new UsernameNotFoundException("用户不存在");
        }
        return user;
    }
}
