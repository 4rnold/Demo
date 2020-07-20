//package com.example2.demo.consumer;
//
//import org.apache.kafka.common.protocol.types.Field;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KafkaConsumerService {
//
////    @KafkaListener(topics = {"testDemo"},groupId = "group1", containerFactory="kafkaListenerContainerFactory")
////    public void kafkaListener(String message){
////        String name = Thread.currentThread().getName();
////        System.out.println(message + ":" + name);
////    }
//
//    @KafkaListener(topics = "testDemo", groupId = "group1", containerFactory="kafkaListenerContainerFactory")
//    public void kafkaListener(@Payload String message,
//                              @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
////                              @Header(KafkaHeaders.PARTITION_ID) String partitionId,
////                              @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int receivedPartitionId,
//
//                              @Header(KafkaHeaders.RECEIVED_PARTITION_ID) String receivedPartitionId
////                              @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key
//    ) {
//        System.out.println("主题:" + topic);
////        System.out.println("键key:" + key);
////        System.out.println("partitionId:" + partitionId);
//        System.out.println("receivedPartitionId:"+ receivedPartitionId);
//        System.out.println("消息:" + message);
//    }
////
////    @KafkaListener(topics = {"testDemo"},groupId = "group2", containerFactory="kafkaListenerContainerFactory")
////    public void kafkaListener2(String message){
////        System.out.println(message);
////    }
////
////    @KafkaListener(topics = {"testDemo"},groupId = "group3", containerFactory="kafkaListenerContainerFactory")
////    public void kafkaListener3(String message){
////        System.out.println(message);
////    }
//
//}