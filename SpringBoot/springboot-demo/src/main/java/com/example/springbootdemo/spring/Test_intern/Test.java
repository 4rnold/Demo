package com.example.springbootdemo.spring.Test_intern;

public class Test {


//    public static void main(String[] args) {
//        String s = new String("1");
//        s.intern();
//        String s2 = "1";
//        System.out.println(s == s2);
//
//        String s3 = new String("1") + new String("1");
//        s3.intern();
//        String s4 = "11";
//        System.out.println(s3 == s4);
//    }

    public static void main(String[] args) throws InterruptedException {
        String s = new String("11");
        String s5 = new String("11");
        System.out.println(s == s5);
        s.intern();
        String s2 = "11";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
        System.out.println(s2 == s4);

        Thread.currentThread().join();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
