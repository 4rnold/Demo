package com.example.springbootdemo.redis.T8_Redis_Delay_queue;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import javafx.concurrent.Task;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;


@Slf4j
public class RedisDelayingQueue<T> {

    private ZSetOperations<String, Object> zSetOperations;
    private String queueKey;

    public RedisDelayingQueue(ZSetOperations<String, Object> zSetOperations, String queueKey) {
        this.zSetOperations = zSetOperations;
        this.queueKey = queueKey;
    }

    @Getter
    @Setter
    static class TaskItem<T> {
        public String id;
        public T msg;
    }

    public void delay(T msg) {
        System.out.println(msg);
        log.info(JSONUtil.toJsonStr(msg));
        TaskItem<T> tTaskItem = new TaskItem<>();
        String id = UUID.randomUUID().toString();
        tTaskItem.msg = msg;
        String itemJsonStr = JSONUtil.toJsonStr(tTaskItem);
        log.info(itemJsonStr);
        zSetOperations.add(queueKey, itemJsonStr, System.currentTimeMillis() + 20000 );
    }

    public void loop() {
        while (!Thread.interrupted()) {
            Set<Object> objects = zSetOperations.rangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
            if (objects.isEmpty()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
                continue;
            } else {
                String value = (String) objects.iterator().next();
                Long remove = zSetOperations.remove(queueKey, value);
                if (remove > 0) {
                    TaskItem taskItem = JSONUtil.toBean(value, TaskItem.class);
                    this.handleMsg(taskItem);
                }
            }
//            zSetOperations.reverseRange()
        }
    }

    private void handleMsg(TaskItem taskItem) {
        System.out.println(taskItem.msg);
        System.out.println(DateUtil.now());

    }

}
