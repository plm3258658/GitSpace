package com.pp.designModeDemo;
import java.util.Observable;
import java.util.Observer;

class Human implements  Observer{//这些所有观察者
    @Override
    public void update(Observable o, Object arg) {//一旦关注的事情发生了变化
        if(o instanceof  House){ //如果现在发现house这个被观察者改变了
            if(arg instanceof Double){
                    System.out.println("关注的房价上涨了，新价格"+arg);
            }
        }
    }
}
class House extends Observable{//被观察者
    private double price;
    public House(double price){
        this.price=price;
    }
    public void setPrice(double price){
        if(price>this.price){//价格上涨了
            super.setChanged();//关注的内容改变了
            super.notifyObservers(price);//唤醒所有的观察者，并通知他们
        }
    }
}

public class observerByJavaDemo {
    public static void main(String[] args){
        Human h1=new Human();
        Human h2=new Human();
        Human h3=new Human();
        House house=new House(80000.00);
        house.addObserver(h1);      //必须手工设置观察者
        house.addObserver(h2);
        house.addObserver(h3);
        house.setPrice(150000.0);
    }
}
