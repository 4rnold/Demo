package com.example.springbootdemo.spring.T200509_ValidatedServiceParameter;

import com.example.springbootdemo.spring.T200509_ValidatedServiceParameter.entity.TestEntity;
import com.example.springbootdemo.spring.T200509_ValidatedServiceParameter.service.HelloService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {RootConfig.class})
@SpringBootTest(classes = T200509_ValidatedServiceParameterApplication.class)
public class TestSpringBean {

    @Autowired
    private HelloService helloService;

    @Test
    public void test1() {
        System.out.println(helloService.getClass());
        helloService.hello(1, null);
    }

    @Test
    public void test2() {
        TestEntity testEntity = new TestEntity();
        testEntity.setId(14);
        testEntity.setName("aaaaaa");
        helloService.testObj(testEntity);
        System.out.println("over");
    }

//    @Test
//    public void test3() throws JsonProcessingException {
//        TestEntity testEntity = new TestEntity();
//        testEntity.setId(14);
//        testEntity.setName("aaaa");
//        testEntity.setDate(new Date());
//        ObjectMapper objectMapper = new ObjectMapper();
//        String s = objectMapper.writeValueAsString(testEntity);
//        System.out.println(s);
//    }
}