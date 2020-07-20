package com.example2.detail;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class ConsumerConfigDemo_SingleContainer {
    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> propsMap = new HashMap<>();
        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return propsMap;
    }

    @Bean
    public ConsumerFactory<Integer, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    /**
     * 创建 KafkaMessageListenerContainer 实例监听 kafka 消息
     * 一般使用 Spring For Kafka 组件时都会创建 KafkaListenerContainerFactory Bean
     * 来代理 多个 KafkaMessageListenerContainer 完成消费者多线程消费。
     */
    @Bean
    public KafkaMessageListenerContainer demoListenerContainer() {
        // 创建container配置参数，并指定要监听的 topic 名称
        ContainerProperties properties = new ContainerProperties("test");
        // 设置消费者组名称
        properties.setGroupId("group2");
        // 设置监听器监听 kafka 消息
        properties.setMessageListener(new MessageListener<Integer,String>() {
            @Override
            public void onMessage(ConsumerRecord<Integer, String> record) {
                System.out.println("消息：" + record);
            }
        });
        return new KafkaMessageListenerContainer(consumerFactory(), properties);
    }

}