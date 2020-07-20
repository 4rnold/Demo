package com.example.springbootdemo.spring.ConvertionService_and_PropertyEditor_and_HttpMessageConverter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;



@RequestMapping
@Controller
public class TestPropertyEditorController {


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(MyEntity.class, new MyEntityPropertyEditor());
    }


    @RequestMapping("/testPropertyEditor/PathVariable/{myEntity}")
    @ResponseBody
    public MyEntity test(@PathVariable MyEntity myEntity) {
        System.out.println(myEntity.toString());

        return myEntity;
    }

    @RequestMapping("/testPropertyEditor/RequestParam")
    @ResponseBody
    public MyEntity test2(@RequestParam MyEntity myEntity) {
        System.out.println(myEntity.toString());

        return myEntity;
    }

    @RequestMapping("/testPropertyEditor/ModelAttribute")
    @ResponseBody
    public MyEntity test3(@ModelAttribute MyEntity myEntity) {
        System.out.println(myEntity.toString());

        return myEntity;
    }

    @RequestMapping("/testPropertyEditor/empty")
    @ResponseBody
    public MyEntity test4(MyEntity myEntity) {
        System.out.println(myEntity.toString());

        return myEntity;
    }





}
