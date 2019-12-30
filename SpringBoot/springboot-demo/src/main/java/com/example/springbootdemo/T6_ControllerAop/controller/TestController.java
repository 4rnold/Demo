package com.example.springbootdemo.T6_ControllerAop.controller;

import com.example.springbootdemo.T6_ControllerAop.beans.ResultBean;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
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
