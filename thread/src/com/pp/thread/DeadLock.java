package com.pp.thread;
class Pen{
    public synchronized  void get(Note note){

    }
    public synchronized void result(){
        System.out.println("");
    }
}
class Note{
    public synchronized  void  get(Pen pen){

    }
    public synchronized void result(){
        System.out.println("");
    }
}

public class DeadLock implements  Runnable{

    public void run(){

    }
}
