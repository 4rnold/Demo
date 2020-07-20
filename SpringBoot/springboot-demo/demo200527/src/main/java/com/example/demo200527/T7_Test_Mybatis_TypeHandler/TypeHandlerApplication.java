package com.example.demo200527.T7_Test_Mybatis_TypeHandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

@SpringBootApplication(exclude= {
        RedisAutoConfiguration.class})
public class TypeHandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TypeHandlerApplication.class, args);
    }

}
