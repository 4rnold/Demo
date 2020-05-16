package com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication()
public class SpringbootDemoApplication {

    public static void main(String[] args) throws IOException {
//        Properties properties = new Properties();
//        InputStream resourceAsStream = SpringbootDemoApplication.class.getClassLoader().getResourceAsStream("general.properties");
//        properties.load(resourceAsStream);
//
//        SpringApplication springApplication = new SpringApplication(SpringbootDemoApplication.class);
//        springApplication.setDefaultProperties(properties);
//        springApplication.run(args);

        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
