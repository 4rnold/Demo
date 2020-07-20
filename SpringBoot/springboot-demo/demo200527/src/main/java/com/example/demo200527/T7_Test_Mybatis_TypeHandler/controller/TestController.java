package com.example.demo200527.T7_Test_Mybatis_TypeHandler.controller;


import com.example.demo200527.T7_Test_Mybatis_TypeHandler.common.controller.CurdController;
import com.example.demo200527.T7_Test_Mybatis_TypeHandler.entity.TestEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  控制器
 * </p>
 *
 * @author arnold
 * @since 2020-01-10
*/
@RestController
@RequestMapping("/Test_Mybatis_TypeHandler/test")
public class TestController extends CurdController<TestEntity> {

}
