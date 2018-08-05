package com.zek.pattern.decorator;

/**
 * @Description 装饰器模式
 * @Auther zhangkai
 * @DateTime 2018/8/5 下午8:00
 */
public class DecoratorPattern {

    public interface Component {
        void operation();
    }

    public abstract static class Decorator implements Component {

        private Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        @Override
        public void operation() {
            this.component.operation();
        }
    }

    /**
     * 被装饰目标
     */
    public static class ConcreteComponet implements Component {
        @Override
        public void operation() {
            System.out.println("this is 具体的被装饰者");
        }
    }

    /**
     * 装饰器A
     */
    public static class ConcreteDecoratorA extends Decorator {

        private Component component;

        public ConcreteDecoratorA(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            System.out.println("this is 装饰器A 加强");
            super.operation();
        }
    }

    /**
     * 装饰器B
     */
    public static class ConcreteDecoratorB extends Decorator {

        private Component component;

        public ConcreteDecoratorB(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            System.out.println("this is 装饰器B 加强");
            super.operation();
        }
    }


    public static void main(String[] args) {
        Component a = new ConcreteDecoratorB(new ConcreteDecoratorA(new ConcreteComponet()));
        a.operation();
    }

    /**
     * result:
     * this is 装饰器B 加强
     * this is 装饰器A 加强
     * this is 具体的被装饰者
     */

}
