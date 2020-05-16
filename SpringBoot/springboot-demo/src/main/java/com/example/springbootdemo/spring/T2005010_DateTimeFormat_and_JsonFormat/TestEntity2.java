package com.example.springbootdemo.spring.T2005010_DateTimeFormat_and_JsonFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import java.util.Date;

@Data
public class TestEntity2 {

    //    @Min(5)
    @Length(min = 5)
    private String name;

    @Min(5)
    private Integer id;

    //    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    /*
    JsonFormat 输入输出都可以

    POST /testdate HTTP/1.1
    Host: localhost:8082
    Content-Type: application/json
    Cache-Control: no-cache
    Postman-Token: e9017210-0f4d-c86c-51c8-18f7ccafc93d

    {"name":"aaaa","id":1,"date":"2018/11/2 2:22:2"}
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss")
    private Date date;
}
