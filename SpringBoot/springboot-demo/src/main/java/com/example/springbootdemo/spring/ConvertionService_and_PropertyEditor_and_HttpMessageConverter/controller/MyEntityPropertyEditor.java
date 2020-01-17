package com.example.springbootdemo.spring.ConvertionService_and_PropertyEditor_and_HttpMessageConverter.controller;

import java.beans.PropertyEditorSupport;

public class MyEntityPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] split = text.split("!");
        MyEntity myEntity = new MyEntity();
        myEntity.setName(split[0]);
        myEntity.setAge(Integer.valueOf(split[1]));
        setValue(myEntity);
    }

    @Override
    public String getAsText() {

        MyEntity value = (MyEntity) getValue();


        return value.getName() + "-" + value.getAge();
    }
}
