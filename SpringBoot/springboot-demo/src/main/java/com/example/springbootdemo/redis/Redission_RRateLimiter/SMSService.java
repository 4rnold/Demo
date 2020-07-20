package com.example.springbootdemo.redis.Redission_RRateLimiter;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SMSService {

    @Autowired
    private RedissonClient redisson;


    public Boolean sendMsg(String phone) {
        RRateLimiter rateLimiter = redisson.getRateLimiter(phone);
        rateLimiter.trySetRate(RateType.OVERALL, 1, 10, RateIntervalUnit.SECONDS);
        if (rateLimiter.tryAcquire(1)) {
            log.info("send msg to {}", phone);
            return true;
        }
        log.warn("send fail");
        return false;
    }
}
