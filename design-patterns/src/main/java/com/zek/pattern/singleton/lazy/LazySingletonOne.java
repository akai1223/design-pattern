package com.zek.pattern.singleton.lazy;

/**
 * 懒汉式单例模式
 * @author zhangkai
 */
public class LazySingletonOne {
    private static LazySingletonOne instance = null;

    /**
     * 私有构造函数，保证外界无法直接实例化
     */
    private LazySingletonOne(){}

    public static synchronized LazySingletonOne getInstance() {
        if (instance == null) {
            instance = new LazySingletonOne();
        }
        return instance;
    }

    public static synchronized LazySingletonOne getInstance2() {

        synchronized (LazySingletonOne.class) {
            if (instance == null) {
                instance = new LazySingletonOne();
            }
        }
        return instance;
    }

}
