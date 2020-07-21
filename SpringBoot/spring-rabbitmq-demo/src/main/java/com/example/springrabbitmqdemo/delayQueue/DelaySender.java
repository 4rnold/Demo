package com.example.springrabbitmqdemo.delayQueue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.springrabbitmqdemo.delayQueue.DelayedRabbitMQConfig.DELAYED_EXCHANGE_NAME;
import static com.example.springrabbitmqdemo.delayQueue.DelayedRabbitMQConfig.DELAYED_ROUTING_KEY;

@Component
public class DelaySender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendDelayMsg(String msg, Integer delayTime) {
        rabbitTemplate.convertAndSend(DELAYED_EXCHANGE_NAME, DELAYED_ROUTING_KEY, msg, a ->{
            a.getMessageProperties().setDelay(delayTime);
            return a;
        });
    }


}
