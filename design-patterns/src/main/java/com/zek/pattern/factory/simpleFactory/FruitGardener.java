package com.zek.pattern.factory.simpleFactory;

public class FruitGardener {
    /**
     * 静态工厂方法
     */
    public static Fruit fruitFactory(String which) throws BadFruitException {

        if (which.equalsIgnoreCase("Apple")) {
            return new Apple();
        } else if (which.equalsIgnoreCase("Grape")) {
            return new Grape();
        } else {
            throw new BadFruitException("Bad fruit request");
        }
    }
}
