package com.zek.pattern.factory;

/**
 * @author zhangkai
 */
public class Person {
    private static final Person INSTANCE = new Person();

    private Person(){}

    public static Person getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {

        

        System.out.println(Person.getInstance());
    }

}
