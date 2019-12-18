package com.example.springbootdemo.T5_BeanPostProcessor;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder().web(WebApplicationType.NONE).sources(SpringbootDemoApplication.class).bannerMode(Banner.Mode.OFF).run(args);
//        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
