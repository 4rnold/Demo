package com.example.springbootdemo.spring.T2005010_DateTimeFormat_and_JsonFormat;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

@SpringBootApplication(exclude= {RedisAutoConfiguration.class, RedissonAutoConfiguration.class, MybatisPlusAutoConfiguration.class})
public class T2005010_DateTimeFormat_and_JsonFormatApplication {

    public static void main(String[] args) {
        SpringApplication.run(T2005010_DateTimeFormat_and_JsonFormatApplication.class, args);
    }

}
