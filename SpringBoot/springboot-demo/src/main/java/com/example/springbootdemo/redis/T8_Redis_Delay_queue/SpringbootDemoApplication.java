package com.example.springbootdemo.redis.T8_Redis_Delay_queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;

@SpringBootApplication
public class SpringbootDemoApplication implements ApplicationRunner {

    @Autowired
    ValueOperations valueOperations;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

    @Autowired
    RedisDelayingQueue<Integer> redisDelayingQueue;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                redisDelayingQueue.loop();
            }
        });

        thread.start();
    }
}
