package com.example.springbootdemo.spring.FIFOMutex;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

class FIFOMutex {
    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final ConcurrentLinkedQueue<Thread> waiters = new ConcurrentLinkedQueue<Thread>();

    public void lock() {
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        waiters.add(current);
        // Block while not first in queue or cannot acquire lock
        while (waiters.peek() != current ||
                !locked.compareAndSet(false, true)) {
            LockSupport.park(this);
            if (Thread.interrupted()) // ignore interrupts while waiting
                wasInterrupted = true;
        }
        waiters.remove();
        if (wasInterrupted)          // reassert interrupt status on exit
            current.interrupt();
    }

    public void unlock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }

    public static void main(String[] args) {
        FIFOMutex fifoMutex = new FIFOMutex();

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new Task(fifoMutex));
            thread.start();
        }

        System.out.println("111");

    }
}