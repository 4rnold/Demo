package com.example.springbootdemo.spring.T200509_ListParameterValidate.controller;

import com.example.springbootdemo.spring.T200509_ListParameterValidate.entity.ListWrapper;
import com.example.springbootdemo.spring.T200509_ListParameterValidate.entity.TestEntity;
import com.example.springbootdemo.spring.T200509_ListParameterValidate.entity.ValidList;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
//@Validated
public class TestController {

    @RequestMapping("test")
    public String test() {
        return "hello";
    }

    /**
     * 无法校验参数
     * POST /validList HTTP/1.1
     * Host: localhost:8082
     * Content-Type: application/json
     * Cache-Control: no-cache
     * Postman-Token: 15564a08-3cb9-fafc-c931-7ff90ffe161f
     *
     * [{"name":"aaaaaa","id":1}]
     *
     * @param list
     * @return
     */
    @RequestMapping("validList")
    public Object validList(@RequestBody List<TestEntity> list) {
        System.out.println("validList");
        return list;
    }

    /*
    使用对象包装list
    POST /validList2 HTTP/1.1
    Host: localhost:8082
    Content-Type: application/json
    Cache-Control: no-cache
    Postman-Token: 0e3ac2ed-ca11-133f-4879-bfb46391c1ec

    {"list":[{"name":"aaaa","id":1}]}
     */
    @RequestMapping("validList2")
    public Object validList2(@Valid @RequestBody ListWrapper<TestEntity> list, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                System.out.println(allError.getDefaultMessage());
            }
        }
        System.out.println("validList2");
        return list;
    }

    /*
        controller上增加@Validated

        POST /validList3 HTTP/1.1
        Host: localhost:8082
        Content-Type: application/json
        Cache-Control: no-cache
        Postman-Token: 8d584425-dc4f-07c0-1fd6-002c8690b13d

        {"list":[{"name":"aaaa","id":1}]}
     */
    @RequestMapping("validList3")
    public Object validList3(@Valid @RequestBody ListWrapper<TestEntity> list) {
//        if (bindingResult.hasErrors()) {
//            List<ObjectError> allErrors = bindingResult.getAllErrors();
//            for (ObjectError allError : allErrors) {
//                System.out.println(allError.getDefaultMessage());
//            }
//        }
        System.out.println("validList3");
        return list;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String allExceptionHandler(MethodArgumentNotValidException e){
        MethodArgumentNotValidException ex = (MethodArgumentNotValidException)e;
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder errMsg = new StringBuilder(bindingResult.getFieldErrors().size() * 16);
        errMsg.append("Invalid request:");
        for (int i = 0 ; i < bindingResult.getFieldErrors().size() ; i++) {
            if(i > 0) {
                errMsg.append(",");
            }
            FieldError error = bindingResult.getFieldErrors().get(i);
            errMsg.append(error.getField()+":"+error.getDefaultMessage());
        }
        return errMsg.toString();
    }



    /*
    自定义list-ValidList

    POST /validList4 HTTP/1.1
    Host: localhost:8082
    Content-Type: application/json
    Cache-Control: no-cache
    Postman-Token: 638584a8-5def-fe43-5d02-5a1d4e24a655

    [{"name":"aaaaaa","id":1}]
     */
    @RequestMapping("validList4")
    public Object validList4(@Valid @RequestBody ValidList<TestEntity> list) {
//        if (bindingResult.hasErrors()) {
//            List<ObjectError> allErrors = bindingResult.getAllErrors();
//            for (ObjectError allError : allErrors) {
//                System.out.println(allError.getDefaultMessage());
//            }
//        }
        System.out.println("validList4");
        return list;
    }

}
