package com.zek.pattern.factory.simpleFactory;

public class Apple implements Fruit {

    private int treeAge;

    @Override
    public void grow() {

        log("Apple is growing...");
    }

    @Override
    public void plant() {
        log("Apple has been planted.");
    }

    @Override
    public void harvest() {

        log("Apple has been harvested.");
    }

    public void log(String msg){
        System.out.println(msg);
    }

    public int getTreeAge() {
        return treeAge;
    }

    public void setTreeAge(int treeAge) {
        this.treeAge = treeAge;
    }
}
