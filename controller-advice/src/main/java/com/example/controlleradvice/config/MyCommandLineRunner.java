package com.example.controlleradvice.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
@Component
@Order(100)
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(
                "项目初始化启动。。。。。"
        );

        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
