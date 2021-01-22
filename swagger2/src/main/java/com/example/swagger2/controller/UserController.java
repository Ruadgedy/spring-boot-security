package com.example.swagger2.controller;

import com.example.swagger2.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    @ApiOperation("添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "小明"),
            @ApiImplicitParam(name = "address", value = "地址",defaultValue = "上海", required = true)
    })
    public String addUser(String username, @RequestParam(required = true, value = "address") String address){
        return "添加用户成功";
    }

    @GetMapping("/{id}")
    @ApiOperation("根据ID查询用户的接口")
    @ApiImplicitParam(name = "id", value = "用户ID", defaultValue = "1", required = true)
    public User getUserById(@PathVariable Integer id){
        User user = new User();
        user.setId(id);
        return user;
    }

    @PutMapping("/{id}")
    @ApiOperation("根据ID更新用户")
    public User updateUser(@PathVariable("id") Integer id){
        final User user = new User();
        user.setId(id);
        return user;
    }
}
