package com.zek.pattern.factory.abstractfactory;

/**
 * 抽象工厂
 * @author zhangkai
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator1();
        creator.factoryA();
        creator.factoryB();

        creator = new ConcreteCreator2();
        creator.factoryA();
        creator.factoryB();
    }

    /**
     * 抽象工厂生产系列产品
     *
     *
     */
}
