package com.example.springbootdemo.ConvertionService_and_PropertyEditor_and_HttpMessageConverter.config;

import com.example.springbootdemo.ConvertionService_and_PropertyEditor_and_HttpMessageConverter.controller.MyEntityHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {

/*    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        List<MediaType> list = new ArrayList<>();
        list.add(new MediaType("text","arnold"));
        MyEntityHttpMessageConverter myEntityHttpMessageConverter = new MyEntityHttpMessageConverter();
        myEntityHttpMessageConverter.setSupportedMediaTypes(list);
        converters.add(0,myEntityHttpMessageConverter);
    }*/

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

//        List<MediaType> list = new ArrayList<>();
//        list.add(new MediaType("text","arnold"));
        MyEntityHttpMessageConverter myEntityHttpMessageConverter = new MyEntityHttpMessageConverter();
        converters.add(0,myEntityHttpMessageConverter);
    }
}
