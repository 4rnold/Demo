package com.example.springbootdemo.spring.T2005010_DateTimeFormat_and_JsonFormat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "task")
public class TaskController {
 
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity post(@Valid @RequestBody Task task, Errors errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(System.out::println);
            //return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("1111", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/2", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity post2(@Valid @RequestBody TestEntity3 task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(System.out::println);
            //return new ResponseEntity(new ApiErrors(errors), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("1111", HttpStatus.CREATED);
    }

    @RequestMapping("testdate8")
    @ResponseBody
    public Object test234(@Valid @RequestBody TestEntity3 testEntity3,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(System.out::println);
        }
        System.out.println(11);
        return testEntity3;
    }
}