package com.example.springbootdemo.spring.T2005010_DateTimeFormat_and_JsonFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
public class TestEntity3 {

    //    @Min(5)
    @Length(min = 5)
    private String name;

    @Min(value = 5,message = "不能小于5")
    private Integer id;

    /*
    x-www-form-urlencoded可以接收

    POST /testdate3 HTTP/1.1
    Host: localhost:8082
    Content-Type: application/x-www-form-urlencoded
    Cache-Control: no-cache
    Postman-Token: c764abc6-768e-dab0-f46a-19037c33921a

    name=asdf&date=2018-11-2+2%3A22%3A2
     */
    //一般可以key value形式接收参数，但返回还要通过json返回，要加上jsonFormat
    //DateTimeFormat其实是作为Formatter被注册到ConvertionService中了
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    //jsonFormat被MappingJackson2HttpMessageConverter处理

    //RequestResponseBodyMethodProcessor调用AbstractMessageConverterMethodArgumentResolver#readWithMessageConverters(HttpInputMessage, MethodParameter, Type)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd")
    private Date date;
}
