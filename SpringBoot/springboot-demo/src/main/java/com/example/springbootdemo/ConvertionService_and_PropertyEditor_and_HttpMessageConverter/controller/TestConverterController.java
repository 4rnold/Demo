package com.example.springbootdemo.ConvertionService_and_PropertyEditor_and_HttpMessageConverter.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @RequestParam 是 通过 Request.get(xxx) 来获取参数，使用Convertionservice来转换。【参数必须是xxx=yyy形式，必须有xxx参数】
 *
 * @ModelAttribute 相对@RequestParam 区别：可以将xxx=yyy 解析到 Bean中的属性。
 *
 * @RequestBody 就是解析body，通过HttpMessageConverter 来解析Body。
 */
@RequestMapping
@RestController
public class TestConverterController {

    /**
     * 下面都可以通过自定义MyEntityConverter 也就是 ConversionService来转换
     */

    @RequestMapping("/testConversionService/PathVariable/{myEntity}")
    @ResponseBody
    MyEntity test2 (@PathVariable MyEntity myEntity) {
        return myEntity;
    }

    @RequestMapping("/testConversionService/empty")
    @ResponseBody
    MyEntity test3 (MyEntity myEntity) {
        return myEntity;
    }

    @RequestMapping("/testConversionService/RequestParam")
    @ResponseBody
    MyEntity test4 (@RequestParam MyEntity myEntity) {
        return myEntity;
    }

    /**
     * head:application/x-www-form-urlencoded 配合body或param:myEntity=arnold233 可以访问
     * 或者
     * head：application/x-www-form-urlencoded配合body或param:name=rr&age=98
     * 以上两种形式的参数在ServletModelAttributeMethodProcessor中通过两个方法分别来处理的。
     *
     * head:application/json
     * body：{
     * 	"name":"tt",
     * 	"age":55
     * }
     * 不能被接收
     *
     *
     * @param myEntity
     * @return
     */
    @RequestMapping("/testConversionService/ModelAttribute")
    @ResponseBody
    MyEntity test5 (@ModelAttribute MyEntity myEntity) {
        return myEntity;
    }


    /**
     *
     * head:text/arnold body:aaa255 通过MyEntityHttpMessageConverter 转换
     *
     * @param myEntity
     * @return
     */
    @RequestMapping("/testConversionService/RequestBody")
    @ResponseBody
    MyEntity test6 (@RequestBody MyEntity myEntity) {
        return myEntity;
    }
}
