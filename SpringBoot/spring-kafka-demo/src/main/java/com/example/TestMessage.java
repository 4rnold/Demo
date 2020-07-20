package com.example;


import cn.hutool.json.JSONUtil;
import com.example.common.Foo1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
@Slf4j
public class TestMessage {

	@Autowired
	private KafkaTemplate<Object, Object> template;

	/**
	 * 问题：Message<String> 可以接收，Message<Foo1> 不能接收
	 *
	 * curl -X POST http://localhost:8083/testMessageGroup
	 * testMessageGroup 和 testMessageGroup2可以接收，testMessageGroup3不能接收
	 * @param message
	 */
	@KafkaListener(id = "testMessageGroup",topics = {"msg"})
	public void test(Message<String> message) {

		log.info(JSONUtil.toJsonPrettyStr(message));
	}

	@KafkaListener(id = "testMessageGroup2",topics = {"msg"})
	public void test2(String msg) {
		log.info(msg);
	}

	/**
	 * 收不到消息
	 * @param msg
	 */
	@KafkaListener(id = "testMessageGroup3",topics = {"msg"})
	public void test4(Foo1 msg) {
		log.info(JSONUtil.toJsonPrettyStr(msg));
	}


	@RequestMapping("/testMessageGroup")
	public void test1() throws ExecutionException, InterruptedException {
		ListenableFuture<SendResult<Object, Object>> send = template.send("msg", new Foo1("testfoo"));
		log.info("send suc");

		//异步
		send.addCallback(new ListenableFutureCallback<SendResult<Object, Object>>() {

			@Override
			public void onSuccess(SendResult<Object, Object> result) {
				log.info("callback success");
			}

			@Override
			public void onFailure(Throwable ex) {
				log.error("callback error");

			}
		});
	}


	/**
	 * 同步发送
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws TimeoutException
	 */
	@RequestMapping("/testMessageGroupSync")
	public void test5() {
		try {
			template.send("msg", new Foo1("testMessageGroupSyncMsg")).get(10000, TimeUnit.MICROSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

}
