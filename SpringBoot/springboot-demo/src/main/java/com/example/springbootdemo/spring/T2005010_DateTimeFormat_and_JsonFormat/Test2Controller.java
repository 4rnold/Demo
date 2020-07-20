package com.example.springbootdemo.spring.T2005010_DateTimeFormat_and_JsonFormat;


import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
//@Validated
public class Test2Controller {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("testdate")
    public TestEntity2 test(@RequestBody TestEntity2 testEntity2) {
        Date date = testEntity2.getDate();
        System.out.println(date.getHours());
        return testEntity2;
    }


    @RequestMapping("testdate3")
    public TestEntity3 test(@Valid TestEntity3 testEntity3, BindingResult bindingResult) {
        System.out.println(11);
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                System.out.println(allError.getDefaultMessage());
            }
//            System.out.println("eeeeeeeeeeeeeee");
        }
//        String format = DateUtil.format(testEntity3.getDate(), "yyyy|/MM/dd HH:mm:ss");
//        System.out.println(format);
        return testEntity3;
    }

    //modelAttributeMethodProcessor处理，返回bindException
    @RequestMapping("testdate4")
    public TestEntity3 test(@Valid TestEntity3 testEntity3) {
        System.out.println(11);
//        String format = DateUtil.format(testEntity3.getDate(), "yyyy|/MM/dd HH:mm:ss");
//        System.out.println(format);
        return testEntity3;
    }


    @RequestMapping("testdate5")
    public Object test(@Min(5) Integer id) {
        System.out.println(messageSource.toString());
        return id;
    }

    @RequestMapping("testdate6")
    public Object test2(@RequestParam(required = true) Integer id) {
        System.out.println(11);
        return id;
    }

    /*
    RequestParam不支持BindingResult
     */
    @RequestMapping("testdate66")
    public Object test2(@RequestParam(required = true) Integer id,BindingResult result) {
        if (result.hasErrors()) {
            result.getAllErrors().stream().forEach(System.out::println);
        }
        System.out.println(11);
        return id;
    }

    @RequestMapping("testdate7")
    public Object test23(@Valid @RequestBody TestEntity3 testEntity3) {
        System.out.println(11);
        return testEntity3;
    }


    /*
    当类型转换时string 转int，date类型转换由httpMessageConverter来转换。
    转换异常BindingResult不能捕获
    @min验证异常可以
     */
    @RequestMapping("testdate8")
    public Object test234(@Valid @RequestBody TestEntity3 testEntity3,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(System.out::println);
        }
        System.out.println(11);
        return testEntity3;
    }


}
