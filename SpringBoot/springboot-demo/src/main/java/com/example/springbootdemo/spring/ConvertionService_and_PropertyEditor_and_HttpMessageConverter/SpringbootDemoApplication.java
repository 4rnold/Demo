package com.example.springbootdemo.spring.ConvertionService_and_PropertyEditor_and_HttpMessageConverter;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {
        RedisAutoConfiguration.class,
        RedissonAutoConfiguration.class,
        MybatisPlusAutoConfiguration.class,
        DataSourceAutoConfiguration.class})
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
