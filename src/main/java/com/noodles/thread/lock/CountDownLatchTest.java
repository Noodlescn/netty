package com.noodles.thread.lock;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 闭锁测试
 * @Author: noodles
 * @create: 2021-01-20 08:18
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.execute(() -> {
                try {
                    int millis = new Random().nextInt(10000);
                    System.out.println("等待队友进入游戏, 耗时:" + millis + "(millis)");
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }
        // 等待游戏开始
        latch.await();
        System.out.println("已经满员,可以开始游戏!");
        // 关闭线程池
        exec.shutdown();
    }
}
