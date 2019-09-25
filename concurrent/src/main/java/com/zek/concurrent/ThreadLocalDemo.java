package com.zek.concurrent;

/**
 * @author zhangkai
 * @description
 * @date 2019-06-24 18:33
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i< 5; i++){
            new Thread(() -> {

                int a = threadLocal.get();

                System.out.println("a -- " + a++);
            }).start();

        }
    }

    /**
     *
     * Thread 属性 ThreadLocal.ThreadLocalMap
     *
     * ThreadLocalMap   entry extends WeakReference; key -> threadLocal,
     *
     */
}
