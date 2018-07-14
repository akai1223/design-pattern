package com.zek.pattern.factory.factorymethod;

/**
 * 具体工厂角色2
 * @author zhangkai
 */
public class Creator2 implements Creator {
    @Override
    public Product factory() {
        return new ConcreteProduct2();
    }
}
