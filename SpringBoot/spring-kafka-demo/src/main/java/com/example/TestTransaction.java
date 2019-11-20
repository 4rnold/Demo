package com.example;

import com.common.Foo1;
import com.common.Foo2;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
public class TestTransaction {
	@Autowired
	KafkaTemplate<Object,Object> template;

    /**
     * 启用transaction-id-prefix
     * @param what
     */
	@RequestMapping("/testTransaction")
	public void test(@RequestParam String what) {
		//事务，确保全部发送成功
		this.template.executeInTransaction(kafkaTemplate -> {
			StringUtils.commaDelimitedListToSet(what).stream()
					.map(s -> new Foo1(s))
					.forEach(foo -> {
//					if (foo.getFoo().equals("error")) {
//						throw new RuntimeException("send error");
//					}
						kafkaTemplate.send("topic2", foo);
					});
			return null;
		});
	}

	@KafkaListener(id = "fooGroup2", topics = "topic2")
	public void listen1(List<Foo2> foos) throws IOException, InterruptedException {
		log.info("Received: " + foos);
		foos.forEach(f -> template.send("topic3", f.getFoo().toUpperCase()));
		log.info("Messages sent, hit Enter to commit tx");
		Thread.sleep(3000);
		log.info("wakeup");
//		if (1==1) {
//			throw new RuntimeException("eeeeeeeeeeee");
//		}
		System.in.read();
	}

	@KafkaListener(id = "fooGroup3", topics = "topic3")
	public void listen2(List<String> in) {
		log.info("Received: " + in);
	}
}
