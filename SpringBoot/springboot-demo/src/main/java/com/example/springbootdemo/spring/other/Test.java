package com.example.springbootdemo.spring.other;

import java.math.BigDecimal;

public class Test {
      
    private final int a = 10;  
    private final int b = 10;  
    private float c = 11f;  
    private float d = 11f;  
    private float e = 11f;  

    private String s1 = "JVM原理";  
    private String s2 = "JVM原理";

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("0.0001100");
        System.out.println(bigDecimal.unscaledValue());//1100
        System.out.println(bigDecimal.scale());//7  10-7次方
        System.out.println(bigDecimal.precision());//4，就表示unscaledValue的位数？
    }
      
}