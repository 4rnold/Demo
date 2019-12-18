package com.example.feigncustomerservice.controller;

import com.example.feigncustomerservice.integration.CoffeeService;
import com.example.feigncustomerservice.model.CoffeeOrder;
import com.example.feigncustomerservice.model.NewOrderRequest;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustomerController {

    @Autowired
    CoffeeService coffeeService;

    @RequestMapping("/testHystrix")
    @HystrixCommand(fallbackMethod = "fallbackCreateOrder")
    public CoffeeOrder test() {
        NewOrderRequest request = NewOrderRequest.builder().customer("test").build();
        CoffeeOrder coffeeOrder = coffeeService.create(request);
        return coffeeOrder;
    }

    public CoffeeOrder fallbackCreateOrder() {
        log.warn("Fallback to NULL order.");
        CoffeeOrder coffeeOrder = new CoffeeOrder();
        coffeeOrder.setCustomer("fallbackController");
        return null;
    }
}
