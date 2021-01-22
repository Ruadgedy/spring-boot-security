package com.example.https.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/divide")
    public String divide(){
        final int i = 2 / 0;
        return "hello";
    }

    @GetMapping("/ex")
    public String ex() throws Exception {
        throw new Exception("llllll");
    }
}
