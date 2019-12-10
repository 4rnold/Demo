package com.example.springbootdemo.Formatter_and_CustomJsonDeserializer_JsonSerializer.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.money.Money;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class NewCoffeeRequest {
    @NotEmpty(message = "name不能为空啊我的亲")
    private String name;
    @NotNull
    private Money price;
}
