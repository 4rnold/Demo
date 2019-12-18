package com.example.feigncustomerservice;
//开机启动

import cn.hutool.json.JSONUtil;
import com.example.feigncustomerservice.integration.CoffeeService;
import com.example.feigncustomerservice.model.Coffee;
import com.example.feigncustomerservice.model.CoffeeOrder;
import com.example.feigncustomerservice.model.NewOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CustomerRunner implements ApplicationRunner {

    @Autowired
    CoffeeService coffeeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Coffee> all = coffeeService.getAll();
        log.warn(JSONUtil.toJsonStr(all));
        NewOrderRequest request = NewOrderRequest.builder().customer("test").build();
        CoffeeOrder coffeeOrder = coffeeService.create(request);
        System.out.println(JSONUtil.toJsonStr(coffeeOrder));
    }
}
