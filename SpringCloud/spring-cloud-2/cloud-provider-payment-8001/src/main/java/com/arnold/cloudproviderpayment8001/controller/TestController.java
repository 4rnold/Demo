package com.arnold.cloudproviderpayment8001.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/index")
    public String test() {
        return "test2222333444";
    }
}
