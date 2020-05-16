package com.example.springbootdemo.spring.T200509_ListParameterValidate.entity;

import lombok.Data;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
public class ListWrapper<T> {
    @Valid List<T> list;

    public ListWrapper() {
        list = new ArrayList<>();
    }

    public  ListWrapper(List<T> list) {
        this.list = list;
    }
}
