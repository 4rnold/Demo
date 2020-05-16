package com.example.springbootdemo.spring.JVMProcess;

public class DemoInit {
    static
    {
        System.out.println("静态初始化DemoInit");
    }

    public static void main(String[] args) {
        System.out.println("DemoInit的main方法");
        AInit a = new AInit();
        System.out.println(AInit.width);
        AInit a2 = new AInit(); //类只会加载和初始化一次，对象可以new多个。
    }
}

class AInit extends AInit_Father
{
    public static int width = 100;//静态变量，静态域 field
    static
    {
        System.out.println("静态初始化类AInit");
        width = 30;

    }
    public AInit()
    {
        System.out.println("创建AInit类的对象");
    }
}

class AInit_Father{
    static{
        System.out.println("静态初始化AInit_Father");
    }
}