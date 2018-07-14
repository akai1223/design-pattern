package pattern.factory.factorymethod;

/**
 * @author zhangkai
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        Creator creator = new Creator1();
        creator.factory();
        creator = new Creator2();
        creator.factory();
    }
}
