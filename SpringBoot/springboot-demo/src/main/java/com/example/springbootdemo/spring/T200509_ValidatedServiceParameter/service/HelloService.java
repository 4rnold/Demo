package com.example.springbootdemo.spring.T200509_ValidatedServiceParameter.service;

import com.example.springbootdemo.spring.T200509_ValidatedServiceParameter.entity.TestEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

/*
有@Validated的类@Valid就作为嵌套类去解析
 */
@Validated(Default.class)
public interface HelloService {
    Object hello(@NotNull @Min(10) Integer id, @NotNull String name);

    Object testObj(@Valid TestEntity testEntity);
}

