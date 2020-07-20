package com.example.springbootdemo.spring.ParameterBindingResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Slf4j
public class User {

    private Integer id;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModify;


    @Size(min = 2,max = 30)
    private String name;

    @Max(150)
    @Min(18)
    private Integer age;


}