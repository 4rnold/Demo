package com.example.springbootdemo.Formatter_and_CustomJsonDeserializer_JsonSerializer.support;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class MoneyFormatter implements Formatter<Money> {
    @Override
    public Money parse(String text, Locale locale) throws ParseException {
        if (NumberUtils.isParsable(text)) {
            return Money.of(CurrencyUnit.of("CNY"), NumberUtils.createBigDecimal(text));
        } else if (StringUtils.isNoneEmpty(text)) {
            String[] split = StringUtils.split(text, " ");
            if (split != null && split.length == 2 && NumberUtils.isParsable(split[1])) {
                return Money.of(CurrencyUnit.of("CNY"), NumberUtils.createBigDecimal(text));
            }
        }

        throw new ParseException(text, 0);
    }

    @Override
    public String print(Money object, Locale locale) {
        if (object == null) {
            return null;
        }
        return object.getCurrencyUnit().getCode() + " " + object.getAmount();
    }

    public static void main(String[] args) {
//        System.out.println(NumberUtils.isParsable("12.00"));
//        System.out.println(NumberUtils.isCreatable("12.00"));
//        System.out.println(NumberUtils.isDigits("12.00"));
//
//        System.out.println(NumberUtils.isParsable("02"));
//        System.out.println(NumberUtils.isCreatable("02"));

//        NumberUtils.isCreatable("abc");//return false
//        NumberUtils.isCreatable("123");//return true
//        NumberUtils.isCreatable("08");//return false
//        NumberUtils.isCreatable("09");//return false
    }
}
