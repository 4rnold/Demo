package com.example.springbootdemo.spring.FIFOMutex;

import java.util.concurrent.locks.LockSupport;

public class Task implements Runnable {

    private FIFOMutex fifoMutex;

    public Task(FIFOMutex fifoMutex) {
        this.fifoMutex = fifoMutex;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-1");
        fifoMutex.lock();
        System.out.println(Thread.currentThread().getName() + "-2");
        fifoMutex.unlock();
        System.out.println(Thread.currentThread().getName() + "-3");
        fifoMutex.lock();
        System.out.println(Thread.currentThread().getName() + "-4");
        fifoMutex.unlock();
    }

}
