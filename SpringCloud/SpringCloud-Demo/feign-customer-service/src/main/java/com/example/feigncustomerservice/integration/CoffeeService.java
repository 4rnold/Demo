package com.example.feigncustomerservice.integration;

import com.example.feigncustomerservice.model.Coffee;
import com.example.feigncustomerservice.model.CoffeeOrder;
import com.example.feigncustomerservice.model.NewOrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "waiter-service", contextId = "coffee", path = "/coffee", fallback = FallbackCoffeeService.class)
public interface CoffeeService {

    @GetMapping(path = "/", params = "!name")
    List<Coffee> getAll();

    @PostMapping(path = "/order/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    CoffeeOrder create(@RequestBody NewOrderRequest newOrder);

}
