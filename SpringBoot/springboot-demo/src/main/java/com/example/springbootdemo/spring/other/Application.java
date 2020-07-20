package com.example.springbootdemo.spring.other;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= {
        RedisAutoConfiguration.class,
        RedissonAutoConfiguration.class,
        MybatisPlusAutoConfiguration.class,
        DataSourceAutoConfiguration.class})
@ComponentScan(value = "sss")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
