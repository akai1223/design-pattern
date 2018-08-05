package com.zek.pattern.adapter;

import com.zek.pattern.adapter.ClassAdapter.Source;

/**
 * @Description 对象适配器模式
 * @Auther zhangkai
 * @DateTime 2018/8/5 下午7:28
 */
public class ObjectAdapter {

    public static class Adapter implements ClassAdapter.TargetInterface {

        private Source source;

        public Adapter(Source source) {
            this.source = source;
        }

        @Override
        public void method1() {
            source.method1();
        }

        @Override
        public void method2() {
            System.out.println("this is 对象适配 method2 !");
        }
    }

    public static void main(String[] args) {
        Adapter adapter = new Adapter(new Source());
        adapter.method1();
        adapter.method2();
    }

    /**
     * result:
     * this original method1
     * this is 对象适配 method2 !
     */

}
