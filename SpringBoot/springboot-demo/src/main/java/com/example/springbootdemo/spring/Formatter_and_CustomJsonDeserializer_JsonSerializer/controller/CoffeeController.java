package com.example.springbootdemo.spring.Formatter_and_CustomJsonDeserializer_JsonSerializer.controller;

import com.example.springbootdemo.spring.Formatter_and_CustomJsonDeserializer_JsonSerializer.model.Coffee;
import com.example.springbootdemo.spring.Formatter_and_CustomJsonDeserializer_JsonSerializer.model.ResponseData;
import com.example.springbootdemo.spring.Formatter_and_CustomJsonDeserializer_JsonSerializer.request.NewCoffeeRequest;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * APPLICATION_FORM_URLENCODED_VALUE 因为通过RequestParamMethodArgumentResolver（@RequestParam）或ServletModelAttributeMethodProcessor（@ModelAttribute）通过调用ConvertionService来做类型转换，Formatter也是Converter，所以使用Formatter转换。
 *
 * APPLICATION_JSON_VALUE 通过RequestResponseBodyMethodProcessor来处理，RequestResponseBodyMethodProcessor使用HttpMessageConverter转换HttpMessageConverter中需要用到json序列化器。所以使用自定义Deserializer
 *
 * 因为输出都加了@ResponseBody 所以都通过Serializer来序列化
 *
 *
 * 加入		<!-- 增加Jackson XML支持 -->
 * 		<dependency>
 * 			<groupId>com.fasterxml.jackson.dataformat</groupId>
 * 			<artifactId>jackson-dataformat-xml</artifactId>
 * 			<version>2.9.0</version>
 * 		</dependency>
 */
@RequestMapping
@Controller
public class CoffeeController {

    @PostMapping(path = "/coffee", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public ResponseData test3(@Valid @ModelAttribute NewCoffeeRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            HashMap<String, Object> resultMap = new HashMap<>();

            for (FieldError fieldError : fieldErrors) {
                String field = fieldError.getField();
                String defaultMessage = fieldError.getDefaultMessage();
                resultMap.put(field, defaultMessage);
            }
            return ResponseData.badRequest().putDataValue("error",resultMap);
        }
        Coffee coffee = new Coffee(1L, new Date(), new Date(), "form" + request.getName(), request.getPrice());
        return ResponseData.ok().putDataValue("coffee", coffee);
    }


/*    @RequestMapping(path = "/coffee", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public Coffee test2(@Valid @ModelAttribute NewCoffeeRequest request) {
        Coffee coffee = new Coffee(1L, new Date(), new Date(), "form" + request.getName(), request.getPrice());
        return coffee;
    }*/


    @PostMapping(path = "/coffee", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Coffee test(@Valid @RequestBody NewCoffeeRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return null;
        }
        Coffee coffee = new Coffee(1L, new Date(), new Date(), "json" + request.getName(), request.getPrice());
        return coffee;
    }


    @GetMapping(path = "/coffee", params = "!name")
    @ResponseBody
    public List<Coffee> getAll() {
        ArrayList<Coffee> coffees = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            coffees.add(new Coffee(1L, new Date(), new Date(), "name", Money.of(CurrencyUnit.AUD,12.34)));
        }

        return coffees;
    }

    @GetMapping(path = "/coffee", params = "name")
    @ResponseBody
    public Coffee getByName(@RequestParam String name) {
        System.out.println(name);
        return new Coffee(1L, new Date(), new Date(), name, Money.of(CurrencyUnit.AUD,12.34));
    }
}
