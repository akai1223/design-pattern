package pattern.factory.abstractfactory;

public class ConcreteCreator1 implements Creator {

    @Override
    public ProductA factoryA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB factoryB() {
        return new ConcreteProductB1();
    }
}
