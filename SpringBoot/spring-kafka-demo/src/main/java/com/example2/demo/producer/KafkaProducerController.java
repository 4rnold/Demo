package com.example2.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService producerService;

    @GetMapping("/sync")
    public void sendMessageSync() throws InterruptedException, ExecutionException, TimeoutException {
        producerService.sendMessageSync("testDemo","同步发送消息测试");
    }

    @GetMapping("/async")
    public void sendMessageAsync(){
        producerService.sendMessageAsync("test","异步发送消息测试");
    }

}