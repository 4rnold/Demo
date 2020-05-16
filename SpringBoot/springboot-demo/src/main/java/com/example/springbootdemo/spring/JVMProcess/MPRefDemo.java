package com.example.springbootdemo.spring.JVMProcess;

public class MPRefDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        //主动引用
        //new AInitRef();
        //System.out.println(AInitRef.width);会初始化AInitRef
        //反射调用也会初始化
        //Class.forName("JVMProcess.AInitRef");

        //被动引用
        //常量
        //System.out.println(AInitRef.MAX);//不会初始化AInitRef
        //数组定义类引用
        //AInitRef[] as = new AInitRef[10];
        //System.out.println(B.width);//B不会初始化，AInitRef会初始化
        System.out.println(B.MAX);//B和AInitRef都不会初始化


    }
}


class B extends AInitRef
{
    static
    {
        System.out.println("静态初始化类B");
    }
}

class AInitRef extends AInit_FatherRef
{
    public static int width = 100;//静态变量，静态域 field
    final static int MAX = 100;

    static
    {
        System.out.println("静态初始化类AInit");
        width = 30;

    }
    public AInitRef()
    {
        System.out.println("创建AInit类的对象");
    }
}

class AInit_FatherRef{
    static{
        System.out.println("静态初始化AInit_Father");
    }
}