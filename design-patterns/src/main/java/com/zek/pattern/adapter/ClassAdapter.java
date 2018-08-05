package com.zek.pattern.adapter;

/**
 * @Description 类适配器模式
 * @Auther zhangkai
 * @DateTime 2018/8/5 下午7:16
 */
public class ClassAdapter {

    public static class Source {
        public void method1() {
            System.out.println("this original method1");
        }
    }

    public interface TargetInterface {

        void method1();

        void method2();

    }

    public static class Adapter extends Source implements TargetInterface {

        @Override
        public void method2() {
            System.out.println("this is target method2!");
        }
    }

    public static void main(String[] args) {
        Adapter adapter = new Adapter();

        adapter.method1();
        adapter.method2();
    }

    /**
     * result:
     * this original method1
     * this is target method2!
     */
}
