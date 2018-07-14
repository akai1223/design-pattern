package pattern.factory.factorymethod;

/**
 * 具体工厂角色1
 * @author zhangkai
 */
public class Creator1 implements Creator {
    @Override
    public Product factory() {
        return new ConcreteProduct1();
    }
}
