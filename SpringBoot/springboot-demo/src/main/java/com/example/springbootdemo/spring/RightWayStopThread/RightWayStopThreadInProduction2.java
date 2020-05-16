package com.example.springbootdemo.spring.RightWayStopThread;

import static java.lang.Thread.sleep;

public class RightWayStopThreadInProduction2 implements Runnable{

    @Override
    public void run() {

        while(true){
            if (Thread.currentThread().isInterrupted()) {//响应中断退出
                System.out.println("线程中断");
                break;
            }
            reInterrupt();
        }

    }

    private void reInterrupt() {

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProduction2());
        thread.start();
        sleep(1000);
        thread.interrupt();
    }
}
