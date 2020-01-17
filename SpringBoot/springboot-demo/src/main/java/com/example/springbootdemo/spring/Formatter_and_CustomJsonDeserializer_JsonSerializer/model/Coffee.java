package com.example.springbootdemo.spring.Formatter_and_CustomJsonDeserializer_JsonSerializer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coffee implements Serializable {

    private Long id;
    private Date createTime;
    private Date updateTime;

    private String name;

    private Money price;
}