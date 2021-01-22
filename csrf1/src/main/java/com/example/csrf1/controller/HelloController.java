package com.example.csrf1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuhao
 * @date: 2021/1/20
 * @description:
 */
@Controller
public class HelloController {
    @PostMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello")
    public String hello2(){
        return "hello";
    }
}
