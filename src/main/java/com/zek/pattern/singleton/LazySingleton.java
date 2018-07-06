package com.zek.pattern.singleton;

/**
 * 懒汉式单例模式
 * @author zhangkai
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    /**
     * 私有构造函数，保证外界无法直接实例化
     */
    private LazySingleton(){}

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static LazySingleton getInstance2() {

        synchronized (LazySingleton.class) {
            if (instance == null) {
                instance = new LazySingleton();
            }
        }
        return instance;
    }

}
