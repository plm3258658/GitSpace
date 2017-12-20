package com.pp.reflect;
//基本的工厂设计类
interface IFruit{
    public void eat();
}
interface IMessage{
    public void print();
}
class  messageImpl implements  IMessage{
    @Override
    public void print(){
        System.out.println("print message");
    }
}
class apple implements IFruit{
    @Override
    public void eat(){
        System.out.println("吃苹果");
    }
}
class orange implements IFruit{
    @Override
    public void eat(){
        System.out.println("吃橘子");
    }
}
class cherry implements IFruit{
    @Override
    public void eat(){
        System.out.println("吃樱桃");
    }
}
class Factory{
    private Factory(){}
    public static <T>T getInstance(String className){
        T obj=null;
        try {
            obj=(T) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  obj;
    }
}

public class factoryClass {
    public static void main(String[] args)throws Exception{
       IFruit fruit=Factory.getInstance("com.pp.reflect.orange");
        fruit.eat();
        IMessage msg=Factory.getInstance("com.pp.reflect.messageImpl");
        msg.print();
    }
}
