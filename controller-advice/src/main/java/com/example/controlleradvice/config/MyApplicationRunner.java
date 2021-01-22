package com.example.controlleradvice.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
@Component
@Order(95)
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        args.getNonOptionArgs(); // *获取命令行中的无key参数,和CommandLineRunner一样
        args.getOptionNames(); // *获取所有key/value的参数key
        args.getOptionValues("11");  // *获取指定key的参数value
        args.getSourceArgs(); // *获取命令行中的所有参数
    }
}
