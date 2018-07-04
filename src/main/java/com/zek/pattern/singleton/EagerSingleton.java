package com.zek.pattern.singleton;

/**
 * 饿汉式单例模式
 * @author zhangkai
 */
public class EagerSingleton {
    public static final EagerSingleton instance = new EagerSingleton();

    /**
     * 私有构造函数，保证不能被外界利用构造函数创建任意多的实例，私有构造函数，类不能被继承
     */
    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
