package com.example.controlleradvice.exception;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
@ControllerAdvice
public class MyGlobalExceptionHandler {

    // 全局数据绑定
    @ModelAttribute(name = "md")
    public Map<String, Object> mydata(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("age", 99);
        map.put("sex", "男");
        return map;
    }

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView nullPointerException(NullPointerException e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("nullpointer");
        modelAndView.addObject("message", "空指针异常");
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception e){
        final ModelAndView view = new ModelAndView();
        view.setViewName("exception");
        view.addObject("msg", "出错啦");
        return view;
    }

    @InitBinder("b")
    public void b(WebDataBinder binder){
        binder.setFieldDefaultPrefix("b.");
    }

    @InitBinder("a")
    public void a(WebDataBinder binder){
        binder.setFieldDefaultPrefix("a.");
    }
}
