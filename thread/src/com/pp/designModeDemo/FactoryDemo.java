package com.pp.designModeDemo;

/**
 * 工厂模式
 *
 */

interface IFruit {
    public void eat();
}
class Apple implements IFruit {

    @Override
    public void eat() {
        System.out.println("Apple吃苹果");
    }
}
class Orange implements IFruit {

    @Override
    public void eat() {
        System.out.println("Orange吃橘子");
    }
}
class Factory1 {
    public Factory1() {
    }
    public static <T>T getInstance(String className) {
        T obj=null;
        try {
            obj=(T)Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}


public class FactoryDemo {
    public static void main(String[] args)throws Exception{
//        IFruit iFruit=Factory1.getInstance("apple");
//        iFruit.eat();
        IFruit iFruit=Factory1.getInstance("com.pp.designModeDemo.Orange");
        iFruit.eat();
        IFruit iFruit1=Factory1.getInstance("com.pp.designModeDemo.Apple");
        iFruit1.eat();
    }
}
