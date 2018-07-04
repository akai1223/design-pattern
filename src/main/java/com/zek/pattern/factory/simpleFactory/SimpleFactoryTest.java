package com.zek.pattern.factory.simpleFactory;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        Fruit fruit = null;
        try {
            fruit = FruitGardener.fruitFactory("Apple");
            fruit.grow();
            fruit.plant();
            fruit.harvest();
        } catch (BadFruitException e) {
            e.printStackTrace();
        }
    }

    /**
     * 核心是工厂类，这个类含有必要的判断逻辑，决定什么时候创建哪一个产品类的实例
     *
     * 优点：
     * 客户端免除直接创建产品实例的责任，而仅仅消费“实例”
     * 简单工厂模式通过这种方法实现了对责任的分割
     *
     * 缺点：
     * 1.集中了所有产品的创建逻辑，不能工作，影响全局
     * 2.对创建时机的判断和对哪一种具体产品的判断逻辑混合在一起，扩展困难
     * 3.使用静态方法，不能继承
     *
     * 开闭原则：系统设计允许系统无需修改的情况下，扩展其功能
     * 消费角色，无需修改可以接纳新的产品
     * 工厂角色，增加新产品需要修改源代码
     *
     简单工厂在java中的应用
     1.DateFormat是一个抽象类，提供很多静态工厂方法
     getDateInstance();
     getDateInstance(int style);
     getDateInstance(int style, Locale locale);
     一、运用多态性，抽象类接收
     二、静态工厂方法

     */
}
