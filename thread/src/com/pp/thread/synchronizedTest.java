package com.pp.thread;

class MyThread1 implements  Runnable{
    private int ticket=10;//一共票卖出的总数
    @Override
    public void run(){
        for(int x=0;x<20;x++){
            synchronized(this){
                if(this.ticket>0){
                    try {
                        Thread.sleep(20);//模拟延迟
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"卖票，ticket="+this.ticket--);
                }
            }
        }
    }
}

public class synchronizedTest {
    public static void main(String[] args){
        MyThread1 mt=new MyThread1();
        new Thread(mt,"票贩子A").start();
        new Thread(mt,"票贩子B").start();
        new Thread(mt,"票贩子C").start();
    }
}
