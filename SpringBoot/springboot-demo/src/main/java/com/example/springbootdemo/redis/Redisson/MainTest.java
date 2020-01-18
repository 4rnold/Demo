package com.example.springbootdemo.redis.Redisson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SpringbootDemoApplication.class)
@RunWith(SpringRunner.class)
public class MainTest {

    @Autowired
    Redisson redisson;

    /**
     * 先运行test 再运行test2，将test终止掉，test2稍等能正常运行。说明redisson锁可防止死锁。
     * @throws InterruptedException
     */

    @Test
    public void test() throws InterruptedException {
        RLock lock = redisson.getLock("anyLock");
        lock.lock();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("线程执行");
                } finally {
                    lock.unlock();
                }

            }
        });
        thread.start();
        Thread.sleep(50000);
        System.out.println("main thread");
        lock.unlock();
    }

    @Test
    public void test2() throws InterruptedException {
        RLock lock = redisson.getLock("anyLock");
        lock.lock();
        System.out.println(2);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("2线程执行");
                } finally {
                    lock.unlock();
                }

            }
        });
        thread.start();
        Thread.sleep(50000);
        System.out.println("main thread");
        lock.unlock();
    }


}
