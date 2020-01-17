package com.example.springbootdemo.spring.ConvertionService_and_PropertyEditor_and_HttpMessageConverter.controller;

import lombok.Data;

@Data
public class MyEntity {

    private String name;

    private Integer age;

    public MyEntity() {
    }

    MyEntity(String string) {
        String[] split = string.split("2");
        this.name = split[0];
        this.age = Integer.valueOf(split[1]);
    }

}
