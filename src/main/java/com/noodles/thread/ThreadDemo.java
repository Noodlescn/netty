package com.noodles.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName ThreadDemo
 * @Description AtomicInteger 测试
 *      参考链接： https://blog.csdn.net/zhaow823/article/details/80235463
 * @Author noodles
 * @Date 2021/4/12 16:19
 */
public class ThreadDemo {

    public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ThreadTest td = new ThreadTest();
        Thread t1 = new Thread(td);
        Thread t2 = new Thread(td);
        t1.start();
        t2.start();
        System.out.println("startTime: " + System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println("endTime: " + System.currentTimeMillis());
        System.out.println("test");
    }

    static class ThreadTest implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000000000; i++) {
                num.getAndAdd(1);
            }
        }
    }
}
