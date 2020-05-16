package com.example.springbootdemo.spring.T200509_ValidatedServiceParameter.service;

import com.example.springbootdemo.spring.T200509_ValidatedServiceParameter.entity.TestEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

// 实现类如下
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public Object hello(Integer id, String name) {
        return null;
    }

    @Override
    public Object testObj(TestEntity testEntity) {
        return null;
    }
}