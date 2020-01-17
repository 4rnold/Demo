package com.example.springbootdemo.spring.ConvertionService_and_PropertyEditor_and_HttpMessageConverter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyEntityConverter implements Converter<String, MyEntity> {
    @Override
    public MyEntity convert(String source) {
        log.info("MyEntityConverter:{}",source);
        return new MyEntity(source);
    }
}
