package com.zek.concurrent;

public class SyncDemo {

    private int count = 0;

    /**
     * 对象锁
     */
    public synchronized void demo() {
        count++;
    }

    /**
     * 对象锁
     */
    public void demo2() {
        synchronized (this) {
            count++;
        }
    }

    /**
     * 类锁
     */
    public synchronized static void demo3() {
//        count++;
    }

    public void demo4() {

        /**
         * 类锁
         */
        synchronized (SyncDemo.class) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("");
        SyncDemo syncDemo = new SyncDemo();
        SyncDemo syncDemo2 = new SyncDemo();

    }
}
