package com.zek.pattern.singleton.lazy;

/**
 * 内部类实现的懒汉式单例
 * @author zhangkai
 */
public class LazySingletonTwo {


    private boolean initialized = false;

    private LazySingletonTwo() {
        synchronized (LazySingletonTwo.class) {
            if (initialized == false) {
                initialized = !initialized;
            } else {
                throw new RuntimeException("被侵入！");
            }
        }
    }

    public static final LazySingletonTwo getInstance() {
        return LazyHolder.instance;
    }

    public static class LazyHolder {
        private static final LazySingletonTwo instance = new LazySingletonTwo();
    }
}
