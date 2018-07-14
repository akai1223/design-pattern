package pattern.factory.abstractfactory;

public class ConcreteCreator2 implements Creator {
    @Override
    public ProductA factoryA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB factoryB() {
        return new ConcreteProductB2();
    }
}
