package com.example.withjpa;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuhao
 * @date: 2021/1/19
 * @description:
 */
@RestController
public class controller {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/admin/hello")
    public String admin(){
        return "admin";
    }

    @GetMapping("/user/hello")
    public String user(){
        return "user";
    }
}
