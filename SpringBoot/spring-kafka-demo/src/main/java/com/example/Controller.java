/*
 * Copyright 2018-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import cn.hutool.json.JSONUtil;
import com.example.common.TestObj;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.Bar1;
import com.example.common.Foo1;

/**
 * @author Gary Russell
 * @since 2.2.1
 *
 */
@RestController
@Slf4j
public class Controller {

	@Autowired
	private KafkaTemplate<Object, Object> template;

	/**
	 * 发送Foo1, 消费Foo2，因为配置了typeMapper
	 * 	- 生产端：spring.json.type.mapping 配置 typemapping
	 * 	- 消费端：Converter中的TypeMapper
	 * 发送Foo2, 消费Foo1，会转到unknown方法处理，因为unknown是isDefault
	 *
	 * @param what
	 */
	@PostMapping(path = "/send/foo/{what}")
	public void sendFoo(@PathVariable String what) {
		this.template.send("foos", new Foo1(what));
	}

	@PostMapping(path = "/send/bar/{what}")
	public void sendBar(@PathVariable String what) {
		this.template.send("bars", new Bar1(what));
	}

	@PostMapping(path = "/send/unknown/{what}")
	public void sendUnknown(@PathVariable String what) {
		this.template.send("bars", what);
	}

//-------------------------obj----------------------------------

    //curl -X POST http://localhost:8083/send/testObject/arnold
    @PostMapping(path = "/send/testObject/{what}")
    public void testObject(@PathVariable String what) {
        TestObj testObj = new TestObj(new Foo1(what), what);
        this.template.send("obj", testObj);
    }

    @KafkaListener(id = "testobj",topics = {"obj"})
    public void test(TestObj testObj) {
        log.info(JSONUtil.toJsonPrettyStr(testObj));
        if (testObj.getName().equals("error")) {
            throw new RuntimeException("errrr");
        }
    }

    /**
     * [Producer clientId=producer-1] Error while fetching metadata with correlation id 7 : {obj.DLT.DLT=LEADER_NOT_AVAILABLE}
     * @param testObj
     */
//    @KafkaListener(id = "dltGroup", topics = "obj.DLT")
//    public void dltListen(TestObj testObj) {
//        log.info("Received from DLT: " + JSONUtil.toJsonPrettyStr(testObj));
//    }

    /**
     * 死信队列只能接受string？
     * @param string
     */
    @KafkaListener(id = "dltGroup", topics = "obj.DLT")
    public void dltListen2(String string) {
        log.info("Received from DLT: " + string);
    }


//----------------死信队列------------------------
/*
    @PostMapping(path = "/send/dlt/{what}")
    public void sendFoo2(@PathVariable String what) {
        this.template.send("topic1", new Foo1(what));
    }

    *//**
     * errorHandler 设置了重试，报错会重复执行。
     * @param foo
     *//*
    @KafkaListener(id = "fooGroup", topics = "topic1")
    public void listen(Foo2 foo) {
        log.info("Received: " + foo);
        if (foo.getFoo().startsWith("fail")) {
            throw new RuntimeException("failed");
        }
    }

    @KafkaListener(id = "dltGroup2", topics = "topic1.DLT")
    public void dltListen(String in) {
        log.info("Received from DLT: " + in);
    }*/

}
