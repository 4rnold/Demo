package com.example.springbootdemo.redis.Redis_Delay_queue;

import cn.hutool.json.JSONUtil;
import com.example.springbootdemo.redis.Redis_Delay_queue.entity.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


/*
检验 ObjectMapper.enableDefaultTyping的作用

 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class,properties = "com\\example\\springbootdemo\\redis\\T8_Redis_Delay_queue\\application-redis.properties")
public class Test {

    @Autowired
    RedisTemplate redisTemplate;

    @org.junit.Test
    public void test() {
        redisTemplate.opsForValue().set("testtest","123123");
        System.out.println(redisTemplate.opsForValue().get("testtest"));
    }

    @org.junit.Test
    public void test2() {
        User user = new User();
        user.setId(111);
        user.setName("namen");
        redisTemplate.opsForValue().set("testUser2",user);
        Object testUser = redisTemplate.opsForValue().get("testUser2");
        System.out.println(JSONUtil.toJsonStr(testUser));
    }
}
