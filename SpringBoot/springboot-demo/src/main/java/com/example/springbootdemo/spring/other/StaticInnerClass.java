package com.example.springbootdemo.spring.other;

public class StaticInnerClass {

    static {
        System.out.println("static");
    }


    //静态内部类不会触发外部类初始化
    public static class innerCls {

        public String name;
    }

    public static String staticVar = "222";


}
