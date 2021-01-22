package com.example.rediscache.controller;

import com.example.rediscache.entity.User;
import com.example.rediscache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/find")
    public User find(Integer id){
        return userService.get(id);
    }

    @PostMapping("/save")
    public User save(User user){
        return userService.save(user);
    }

    @GetMapping("/delete")
    public void delete(Integer id){
        userService.delete(id);
    }
}
