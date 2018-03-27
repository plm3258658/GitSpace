package com.pp.designModeDemo;

import java.lang.reflect.Constructor;

/**
 * 基本代理模式
 *代理模式的核心本质在于
 * 一个接口有两个子类
 * 一个负责真实业务，一个负责与真实业务有关的辅助性操作
 *
 */

interface ISubject{ //代理模式的核心需要一个核心的操作接口
    public void eat();//吃饭是整体的核心业务
}

class RealSubject implements ISubject{
    @Override
    public void eat(){
        System.out.println("饿了一定要吃饭");
    }
}

class ProxySubject implements ISubject{
    private ISubject subject;
    public ProxySubject(ISubject subject){
        this.subject=subject;
    }
    public void prepare(){
        System.out.println("准备食材");
    }
    public void clear(){
        System.out.println("洗碗");
    }

    @Override
    public void eat() {
        this.prepare();
        this.subject.eat();
        this.clear();
    }
}

class Factory{
    private  Factory(){}
    public static  <T>T getInstance(String className){
        T t=null;
        try {
            t=(T)Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    public static  <T>T getInstance(String proxyClassName,String realClassName){
        T t=null;
        try {
            T obj=(T)Class.forName(realClassName).newInstance();
            Constructor<?> cons=Class.forName(proxyClassName).
                    getConstructor(obj.getClass().getInterfaces()[0]);
            t=(T)cons.newInstance(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}

public class ProxyDemoBasic {
    public static void main(String[] args) throws Exception{
        ISubject subject=Factory.getInstance("com.pp.designModeDemo.ProxySubject",
                "com.pp.designModeDemo.RealSubject");
        subject.eat();
    }
}
