package com.noodles.thread.lock.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 可重入以及公平锁测试
 *      参考链接： https://zhuanlan.zhihu.com/p/88884729
 * @Author: noodles
 * @create: 2021-02-06 20:58
 */
public class ReentrantLockTest2 {

    private static final Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        new Thread(() -> test(), "线程A").start();
        new Thread(() -> test(), "线程B").start();
        new Thread(() -> test(), "线程C").start();
        new Thread(() -> test(), "线程D").start();
        new Thread(() -> test(), "线程E").start();
    }

    public static void test() {
        for (int i = 0; i < 2; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取了锁,循环次数：" + i);
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}
