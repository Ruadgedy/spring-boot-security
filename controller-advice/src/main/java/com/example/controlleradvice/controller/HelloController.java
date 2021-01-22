package com.example.controlleradvice.controller;

import com.example.controlleradvice.entity.Author;
import com.example.controlleradvice.entity.Book;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping("/nullpointer")
    public String nullpointer(){
        String s = null;
        s.toCharArray();
        return "nullpointer";
    }

    @GetMapping("/data")
    @CrossOrigin
    public String getData(Model model){
        final Map<String, Object> map = model.asMap();
        System.out.println(map);
        return "data";
    }


    @PostMapping("/book")
    public void addBook(@ModelAttribute("b") Book book,@ModelAttribute("a") Author author){
        System.out.println(book);
        System.out.println(author);
    }
}
