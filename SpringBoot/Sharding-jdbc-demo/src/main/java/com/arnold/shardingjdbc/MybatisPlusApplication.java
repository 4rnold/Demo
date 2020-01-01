package com.arnold.shardingjdbc;

import org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author Cenyol mail: mr.cenyol@gmail.com
 */
@Controller
@SpringBootApplication(exclude = {SpringBootConfiguration.class})
//@SpringBootApplication
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "hello, now is: " + new Date().toString();
    }

//    @RequestMapping("/generator")
//    @ResponseBody
//    public String generator() {
//        CodeGenerator.main(null);
//        return "hello, now is: " + new Date().toString();
//    }

}
