package com.arnold.febs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author Cenyol mail: mr.cenyol@gmail.com
 */
@Controller
@SpringBootApplication
@SpringBootConfiguration
@Slf4j
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        log.debug("asdfasdfasdf");
        return "hello, now is: " + new Date().toString();
    }

//    @RequestMapping("/generator")
//    @ResponseBody
//    public String generator() {
//        CodeGenerator.main(null);
//        return "hello, now is: " + new Date().toString();
//    }

}
