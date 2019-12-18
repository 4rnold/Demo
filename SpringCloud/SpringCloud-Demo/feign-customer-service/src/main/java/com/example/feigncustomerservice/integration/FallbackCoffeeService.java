package com.example.feigncustomerservice.integration;

import com.example.feigncustomerservice.model.Coffee;
import com.example.feigncustomerservice.model.CoffeeOrder;
import com.example.feigncustomerservice.model.NewOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Slf4j
public class FallbackCoffeeService implements CoffeeService {
    @Override
    public List<Coffee> getAll() {
        return null;
    }

    @Override
    public CoffeeOrder create(NewOrderRequest newOrder) {
        CoffeeOrder coffeeOrder = new CoffeeOrder();
        coffeeOrder.setCustomer("fallback");
        return coffeeOrder;
    }
}
