package com.example.springbootdemo.Formatter_and_CustomJsonDeserializer_JsonSerializer.controller;

import com.example.springbootdemo.Formatter_and_CustomJsonDeserializer_JsonSerializer.model.Coffee;
import com.example.springbootdemo.Formatter_and_CustomJsonDeserializer_JsonSerializer.request.NewCoffeeRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * APPLICATION_FORM_URLENCODED_VALUE 因为通过RequestParamMethodArgumentResolver（@RequestParam）或ServletModelAttributeMethodProcessor（@ModelAttribute）通过调用ConvertionService来做类型转换，Formatter也是Converter，所以使用Formatter转换。
 *
 * APPLICATION_JSON_VALUE 通过RequestResponseBodyMethodProcessor来处理，RequestResponseBodyMethodProcessor使用HttpMessageConverter转换HttpMessageConverter中需要用到json序列化器。所以使用自定义Serializer
 */
@RequestMapping
@Controller
public class CoffeeController {


    @RequestMapping(path = "/coffee", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public Coffee test2(@Valid @ModelAttribute NewCoffeeRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return null;
        }
        Coffee coffee = new Coffee(1L, new Date(), new Date(), "form" + request.getName(), request.getPrice());
        return coffee;
    }


    @RequestMapping(path = "/coffee", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Coffee test(@Valid @RequestBody NewCoffeeRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return null;
        }
        Coffee coffee = new Coffee(1L, new Date(), new Date(), "json" + request.getName(), request.getPrice());
        return coffee;
    }
}
