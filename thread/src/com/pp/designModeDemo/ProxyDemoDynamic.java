package com.pp.designModeDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 动态代理模式（核心）
 * 特点：
 * 一个代理类可以代理所需要被代理接口的子类对象
 */


interface ISubject1{ //代理模式的核心需要一个核心的操作接口
    public void eat(String msg,int num);//吃饭是整体的核心业务
    public void eat1(String msg,int num);//吃饭是整体的核心业务
}
class RealSubject1 implements ISubject1{
    @Override
    public void eat(String msg,int num){
        System.out.println("我要吃"+num+"份"+msg);
    }
    @Override
    public void eat1(String msg,int num){
        System.out.println("我要吃"+num+"份"+msg);
    }
}

class ProxySubject1 implements InvocationHandler{ //一个动态代理类
    private Object target;//绑定任意的接口对象

    /**
     * 实现真实对象的绑定处理，同时返回代理对象
     * @param target
     * @return 返回一个代理对象（这个对象是根据接口定义动态创建形成的代理对象）
     */
    public Object bind(Object target) {
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this) ;
    }

    public void prepare(){
        System.out.println("ProxySubject准备");
    }
    public void clear(){
        System.out.println("ProxySubject收拾");
    }
    /**
     * 动态代理实现的标识接口
     * 只有实现此接口的子类才有动态代理的功能
     * Invocation:调用
     * Handler:处理者
     * Invoke()表示调用执行的方法。但是所有代理类返回给用户的接口对象都属于代理对象
     * 当用户执行接口方法时调用的实例化对象就是该代理主题动态创建的一个接口对象
     * @param proxy  表示被代理的对象信息
     * @param method  返回的是被调用的方法对象，取得了method对象意味着可以使用invoke()反射调用方法
     * @param args 方法中接收的参数
     * @return  方法的返回值
     * @throws Throwable  各种类型的exception或error
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println(proxy.getClass());
        System.out.println(method);
//        System.out.println(Arrays.toString(args));
        this.prepare();
        Object ret=method.invoke(this.target,args);
        this.clear();
        return ret;
    }
}

public class ProxyDemoDynamic {
    public static void main(String[] args) throws Exception{
        ISubject1 iSubject1=(ISubject1) new ProxySubject1().bind(new RealSubject1());
        iSubject1.eat("屎",233);
        iSubject1.eat1("测试",6);
    }
}
