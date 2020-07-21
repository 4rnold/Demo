package com.example.springrabbitmqdemo.deadLetterQueue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.springrabbitmqdemo.deadLetterQueue.DeadLetterMQConfig.DELAY_EXCHANGE_NAME;
import static com.example.springrabbitmqdemo.deadLetterQueue.DeadLetterMQConfig.DELAY_QUEUEC_ROUTING_KEY;

@Component
public class DeadLetterSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg, Integer delayTime) {
        rabbitTemplate.convertAndSend(DELAY_EXCHANGE_NAME, DELAY_QUEUEC_ROUTING_KEY, msg, a ->{
            a.getMessageProperties().setExpiration(String.valueOf(delayTime));
            return a;
        });
    }

}
