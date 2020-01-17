package com.example.springbootdemo.redis.T8_Redis_Delay_queue;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class TestMain {

    @Autowired
    ValueOperations<String, Object> valueOperations;

    @Autowired
    ZSetOperations zSetOperations;

    @Test
    public void test() {
        String test44 =  String.valueOf(valueOperations.get("test44"));
        System.out.println(test44);
    }

    @Test
    public void testZSET() {
        zSetOperations.add("testzset", 999, 100);
        zSetOperations.add("testzset", 77, 300);
        zSetOperations.add("testzset", 88, 200);
    }

    @Test
    public void test2() {
        Set testzset = zSetOperations.rangeByScore("testzset", 99, 301, 1, 2);
        System.out.println(JSONUtil.toJsonStr(testzset));
    }

//    -----------------------------

    @Autowired
    RedisDelayingQueue<Integer> redisDelayingQueue;

    @Test
    public void test3() throws InterruptedException {
        redisDelayingQueue.delay(1111);
        System.out.println(DateUtil.now());
        Thread.sleep(100000);
    }

/*    @Test
    public void test4() {
        Integer integer = 11111;

        String s = JSONUtil.toJsonStr(integer);
        System.out.println(s);
    }

    @Test
    public void test5() {
        RedisDelayingQueue.TaskItem<String> dateTaskItem = new RedisDelayingQueue.TaskItem<>();
        dateTaskItem.msg = "esatasdf";
        dateTaskItem.id = "jjjjj";
        String s = JSONUtil.toJsonStr(dateTaskItem);
        System.out.println(s);
    }*/

}
