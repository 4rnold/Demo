package com.example.springbootdemo.redis.Redisson;

import com.example.springbootdemo.redis.T8_Redis_Delay_queue.RedisDelayingQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootApplication
public class SpringbootDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }


}
