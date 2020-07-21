package com.example.springrabbitmqdemo;

import com.example.springrabbitmqdemo.entity.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class SpringRabbitmqDemoApplicationTests {

    @Test
    void contextLoads() {
    }

//    @Autowired
//    private RabbitAdmin rabbitAdmin;
//
//
//    @Test
//    public void test() {
//        rabbitAdmin.declareExchange(new DirectExchange("test.direct",false,false));
//    }

    @Autowired
    RabbitSender sender;

    @Test
    public void test() {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("number", "123");
        sender.send("message", properties);
    }

    @Test
    public void test2() throws Exception {
        Order order = new Order("001", "第一个订单");
        sender.sendOrder(order);
    }
}
