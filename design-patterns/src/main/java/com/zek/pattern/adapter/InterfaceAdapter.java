package com.zek.pattern.adapter;

import com.zek.pattern.adapter.ClassAdapter.TargetInterface;

/**
 * @Description 接口适配器模式
 * @Auther zhangkai
 * @DateTime 2018/8/5 下午7:39
 */
public class InterfaceAdapter {

    public static abstract class InterAdapter implements TargetInterface {

        @Override
        public void method1() {

        }

        @Override
        public void method2() {

        }
    }

    public static class Adapter extends InterAdapter {


        @Override
        public void method1() {
            System.out.println("this is 接口适配 method1 ！");
        }
    }

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.method1();
    }


    /**
     * result:
     * this is 接口适配 method1 ！
     */

}
