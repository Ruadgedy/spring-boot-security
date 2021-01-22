package com.example.mybatis.controller;

import com.example.mybatis.entity.User;
import com.example.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author yuhao
 * @date: 2021/1/22
 * @description:
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user")
    public User getUserById(String id){
        return userService.getUserById(id);
    }

    @PostMapping("/insert")
    public String insertUser(@RequestBody User user){
        if (user.getId() == null || user.getId().isEmpty()){
            user.setId(UUID.randomUUID().toString());
        }
        userService.addUser(user);
        return "success";
    }

    @PostMapping("/update")
    public String updateUser(@RequestBody User user){
        userService.updateUserById(user);
        return "update success";
    }

    @GetMapping("/delete")
    public String deleteUser(String id){
        userService.deleteUserById(id);
        return "delete success";
    }
}
