package com.pp.designModeDemo;

 class Singleton{
    //类内部私有化，只有通过getInstance访问对象，并且返回的只有一个对象。
    //饿汉式
    //    private final static Singleton INSTANCE =new Singleton();//内部产生实例化对象
    //    public static singleton getInstance(){
    //        return INSTANCE;
    //    }
    //懒汉式
    //使用静态内部类实现，既线程安全，也避免了同步带来的性能影响
    //静态内部类只有在被引用的时候才会装载到内存，所以调用getInstance前没有加载内部类，所以也没有对象实例化
    private static class singletonBuilder{
        private  static Singleton  instance=new Singleton();//内部产生实例化对象
    }
    public static Singleton getInstance(){
        return singletonBuilder.instance;
    }
    //类的内部可以访问私有的结构，所以可以在类的内部产生实例化对象
    private Singleton(){}//私有化无参构造方法，外部无法直接实例化对象。
    public void print(){
        System.out.println("hello world");
    }
}
//单例：一个类只能产生一个实例
public class SingletonDemo {
    public static void main(String[] args){
        Singleton s=null;
        s=Singleton.getInstance();
        s.print();
    }
}
