package com.example.springbootdemo.redis.T8_Redis_Delay_queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ZSetOperations;

@Configuration
public class RedisDelayingQueueConfig {

    @Autowired
    ZSetOperations zSetOperations;

    @Bean
    RedisDelayingQueue<Integer> redisDelayingQueue() {
        return new RedisDelayingQueue<Integer>(zSetOperations, "testDelayQueue");
    }
}
