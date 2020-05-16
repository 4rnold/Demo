package com.example.springbootdemo.spring.T6_ControllerAop;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

@SpringBootApplication(exclude= {RedisAutoConfiguration.class, RedissonAutoConfiguration.class, MybatisPlusAutoConfiguration.class})
public class T6_ControllerAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(T6_ControllerAopApplication.class, args);
    }

}
