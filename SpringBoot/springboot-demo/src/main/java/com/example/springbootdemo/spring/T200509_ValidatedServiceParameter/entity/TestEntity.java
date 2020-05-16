package com.example.springbootdemo.spring.T200509_ValidatedServiceParameter.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import java.util.Date;

@Data
public class TestEntity {

//    @Min(5)
    @Length(min = 5)
    private String name;

    @Min(5)
    private Integer id;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date date;

}
