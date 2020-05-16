package com.example.springbootdemo.spring.T2005010_DateTimeFormat_and_JsonFormat;


import cn.hutool.core.date.DateUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping
public class Test2Controller {

    @RequestMapping("testdate")
    public TestEntity2 test(@RequestBody TestEntity2 testEntity2) {
        Date date = testEntity2.getDate();
        System.out.println(date.getHours());
        return testEntity2;
    }


    @RequestMapping("testdate3")
    public TestEntity3 test(TestEntity3 testEntity3) {
        String format = DateUtil.format(testEntity3.getDate(), "yyyy|/MM/dd HH:mm:ss");
        System.out.println(format);
        return testEntity3;
    }


}
