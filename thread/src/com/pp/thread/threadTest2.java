package com.pp.thread;

class MyThread implements  Runnable{
    @Override
    public void run(){
        for(int x=0;x<20000;x++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"/x="+x);
        }
    }
}

public class threadTest2 {
    public static void main(String[] args){
            MyThread mt=new MyThread();
            new Thread(mt).start();
            new Thread(mt).start();
            new Thread(mt).start();


            Thread t1=new Thread(mt,"A");
            Thread t2=new Thread(mt,"B");
            Thread t3=new Thread(mt,"C");
            t1.start();
            t2.start();
            t3.start();
    }
}
