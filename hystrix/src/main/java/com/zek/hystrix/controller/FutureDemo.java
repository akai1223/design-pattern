package com.zek.hystrix.controller;

import java.util.Random;
import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);

        Random random = new Random();

        Future future = service.submit(() -> {
            int value = random.nextInt(200);
            System.out.println("hello world costs " + value + "ms");

            try {
                Thread.sleep(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "hello world";
        });

        try {
            String res = (String) future.get(100, TimeUnit.MILLISECONDS);
            System.out.println(res);
        } catch (Exception e) {
            System.out.println("服务熔断，超时保护");
        }
    }
}
