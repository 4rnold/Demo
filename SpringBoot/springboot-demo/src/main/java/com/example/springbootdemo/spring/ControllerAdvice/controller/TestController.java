package com.example.springbootdemo.spring.ControllerAdvice.controller;


import com.example.springbootdemo.spring.ControllerAdvice.annotation.IgnoreResponseAdvice;
import com.example.springbootdemo.spring.ControllerAdvice.exception.CouponException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "testset";
    }

    @RequestMapping("/testobj")
    public Date test3() {
        return new Date();
    }

    @RequestMapping("/ignoretest")
    @IgnoreResponseAdvice
    public String test2() {
        return "testset";
    }

    @RequestMapping("/exception")
    public String test4() throws CouponException {
        if (1 == 1) {
            throw  new CouponException("asdf");
        }
        return "asdf";
    }
}
