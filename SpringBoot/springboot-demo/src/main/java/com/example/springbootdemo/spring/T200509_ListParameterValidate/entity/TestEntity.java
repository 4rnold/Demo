package com.example.springbootdemo.spring.T200509_ListParameterValidate.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import java.util.Date;

@Data
public class TestEntity {

//    @Min(5)
    @Length(min = 5)
    private String name;

    @Min(5)
    private Integer id;

}
