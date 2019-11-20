package com.example;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestReplyTemplate {

	@Autowired
	KafkaTemplate<Object,Object> template;


	@KafkaListener(topics = "testReply", groupId = "group1")
	@SendTo("testReply2")
	public String kafkaListener1(String messages, Acknowledgment ack) {
		System.out.println(messages);
		String newMsg = messages + "消息转发测试";
		// 将处理后的消息返回
		ack.acknowledge();
		return newMsg;
	}

	/**
	 * 监听 test2 topic
	 */
	@KafkaListener(topics = "testReply2",groupId = "group2")
	public void kafkaListener2(String messages, Acknowledgment acknowledgment) {
		System.err.println(messages);
		//发送到testReply的消息这里ack不管用
//		acknowledgment.acknowledge();
	}

	/**
	 * 输出：
	 * ttttttt       			testReply 打印，进行加工后 转发给testReply2
 * "ttttttt消息转发测试"			testReply2打印
	 */
	@RequestMapping("/testReply")
	public void test() {
		template.send("testReply", "ttttttt");
	}
}
