package com.example.eurekawaiterservice.controller;

import com.example.eurekawaiterservice.model.*;
import org.apache.commons.lang.math.NumberUtils;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private OrderProperties orderProperties;



    @GetMapping(path = "/", params = "!name")
    List<Coffee> getAll() {
        ArrayList<Coffee> coffees = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Coffee coffee = Coffee.builder().name("coffee" + i + "_discount:" + orderProperties.getDiscount()).price(Money.of(CurrencyUnit.AUD, NumberUtils.createBigDecimal("11.11"))).build();
            coffees.add(coffee);
        }
        return coffees;
    }

    @PostMapping(path = "/order/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    CoffeeOrder create(@RequestBody NewOrderRequest newOrder){
        return CoffeeOrder.builder().state(OrderState.BREWED).id(1111l).customer("discount:" + orderProperties.getDiscount() + "|" +newOrder.getCustomer()).build();
    }
}
