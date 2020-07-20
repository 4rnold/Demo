package com.example.springbootdemo.redis.Redission_RRateLimiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @Autowired
    SMSService smsService;

    @RequestMapping("/testSmsService")
    public String test() throws InterruptedException {
        int i = 0;
        while (i++ < 10000) {

            smsService.sendMsg("11110000");
            Thread.sleep(2000);
        }
        return "111";
    }


}
