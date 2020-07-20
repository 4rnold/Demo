package com.example2.demo.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    /**
     * 消息监听器
     */
//    @KafkaListener( topics = {"test"},groupId = "group1",errorHandler = "listenErrorHandler")
    @KafkaListener(topics = {"testDemo"},groupId = "group1", containerFactory="kafkaListenerContainerFactory")
    public void listen(String message) {
        System.out.println(message);
        // 创建异常，触发异常处理器
        throw new NullPointerException("测试错误处理器");
    }

    /**
     * 异常处理器
     */
    @Bean
    public ConsumerAwareListenerErrorHandler listenErrorHandler() {
        return new ConsumerAwareListenerErrorHandler() {

            @Override
            public Object handleError(Message<?> message,
                                      ListenerExecutionFailedException e,
                                      Consumer<?, ?> consumer) {
                System.out.println("message:" + message.getPayload());
                System.out.println("exception:" + e.getMessage());
                consumer.seek(
                        new TopicPartition(
                            message.getHeaders().get(KafkaHeaders.RECEIVED_TOPIC, String.class),
                            message.getHeaders().get(KafkaHeaders.RECEIVED_PARTITION_ID, Integer.class)
                        ),
                        message.getHeaders().get(KafkaHeaders.OFFSET, Long.class));
                return null;
            }

        };
    }

}