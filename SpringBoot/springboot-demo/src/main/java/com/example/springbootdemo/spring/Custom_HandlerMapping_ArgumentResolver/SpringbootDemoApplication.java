package com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver;


import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;

@SpringBootApplication(exclude= {
        RedisAutoConfiguration.class,
        RedissonAutoConfiguration.class,
        MybatisPlusAutoConfiguration.class,
        DataSourceAutoConfiguration.class})
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
