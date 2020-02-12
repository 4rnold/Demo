package com.example.springbootdemo.mybatis.T7_Test_Mybatis_TypeHandler.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootdemo.mybatis.T7_Test_Mybatis_TypeHandler.TypeHandlerApplication;
import com.example.springbootdemo.mybatis.T7_Test_Mybatis_TypeHandler.entity.TestEntity;
import com.example.springbootdemo.mybatis.T7_Test_Mybatis_TypeHandler.entity.UserStatus;
import com.example.springbootdemo.mybatis.T7_Test_Mybatis_TypeHandler.service.ITestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TypeHandlerApplication.class)
public class TestServiceImplTestEntity {

    @Autowired
    ITestService testService;


    @Test
    public void test() {
//        com.example.springbootdemo.Test_Mybatis_TypeHandler.entity.Test test = new com.example.springbootdemo.Test_Mybatis_TypeHandler.entity.Test();
        TestEntity testEntity = new TestEntity();
//        testEntity.setName("test112");
//        testEntity.setStatus("222");
        testEntity.setStatus(UserStatus.LOGIN);
        boolean save = testService.save(testEntity);
        System.out.println(testEntity.getId());
    }

    @Test
    public void test2() {
        TestEntity entity = testService.getById(2);
        System.out.println(entity);
    }

    @Test
    public void test3() {
        TestEntity testEntity = new TestEntity();
        testEntity.setName("");
        QueryWrapper<TestEntity> testEntityQueryWrapper = new QueryWrapper<>(testEntity);
        List<TestEntity> list = testService.list(testEntityQueryWrapper);
        System.out.println(list);
    }
}