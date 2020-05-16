package com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记Controller handler 的 参数里传入JSON格式的reqBodyJson
 * @author HP
 *
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReqBodyJson {

}
