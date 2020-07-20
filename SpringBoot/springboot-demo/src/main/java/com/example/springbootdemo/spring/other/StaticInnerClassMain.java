package com.example.springbootdemo.spring.other;

public class StaticInnerClassMain {

    public static void main(String[] args) {

        StaticInnerClass.innerCls innerCls = new StaticInnerClass.innerCls();
        innerCls.name = "111";
        System.out.println(innerCls.name);

        String staticVar = StaticInnerClass.staticVar;
        System.out.println(staticVar);
    }



}
