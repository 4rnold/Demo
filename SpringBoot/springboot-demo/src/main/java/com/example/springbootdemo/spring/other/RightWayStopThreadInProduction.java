package com.example.springbootdemo.spring.other;

import static java.lang.Thread.sleep;

public class RightWayStopThreadInProduction implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProduction());
        thread.start();
        sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        while(true){
            System.out.println("go");
//            throwInMethod();
        }
    }

    private void throwInMethod() throws InterruptedException {

        /**
         * 错误做法：这样做相当于就把异常给吞了，导致上层的调用无法感知到有异常
         * 正确做法应该是，抛出异常，而异常的真正处理，应该叫个调用它的那个函数。
         */
       /* try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

       sleep(2000);

    }
}
