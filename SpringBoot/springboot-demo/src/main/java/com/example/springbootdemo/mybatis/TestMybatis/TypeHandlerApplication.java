package com.example.springbootdemo.mybatis.TestMybatis;

import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

@SpringBootApplication(exclude= {
        RedisAutoConfiguration.class,
        RedissonAutoConfiguration.class})
public class TypeHandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TypeHandlerApplication.class, args);
    }

}
