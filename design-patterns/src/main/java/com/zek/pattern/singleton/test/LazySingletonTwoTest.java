package pattern.singleton.test;

import pattern.singleton.lazy.LazySingletonTwo;

import java.lang.reflect.Constructor;

public class LazySingletonTwoTest {
    public static void main(String[] args) {
        Class<?> clazz = LazySingletonTwo.class;
        try {
            //通过反射拿到私有的构造方法
            Constructor<?> constructor = clazz.getDeclaredConstructor(null);
            //强制访问，强吻，不愿意也要吻
            constructor.setAccessible(true);
            Object o1 = constructor.newInstance();
            //调用了两次构造方法，相当于new了两次
            //犯了原则性问题，

            Object o2 = constructor.newInstance();

            System.out.println(o1 == o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
