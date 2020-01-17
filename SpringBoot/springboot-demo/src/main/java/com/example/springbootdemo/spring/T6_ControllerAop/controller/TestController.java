package com.example.springbootdemo.spring.T6_ControllerAop.controller;

import com.example.springbootdemo.spring.T6_ControllerAop.beans.ResultBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public ResultBean<String> test () {
        ResultBean<String> stringResultBean = new ResultBean<>();
        stringResultBean.setData("asdfadf");
        return stringResultBean;
    }
}
