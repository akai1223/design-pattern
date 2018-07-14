package com.zek.pattern.singleton.test;

import com.zek.pattern.singleton.lazy.LazySingletonOne;

import java.util.concurrent.CountDownLatch;

/**
 * @author  zhangkai
 */
public class EagetSingletonTest {

    public static void main(String[] args) {
        int count = 50;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        Long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(LazySingletonOne.getInstance());

                }
            }).start();

            countDownLatch.countDown();
        }

        long end = System.nanoTime();
        System.out.println("总耗时：" + (end - start));
    }
}
