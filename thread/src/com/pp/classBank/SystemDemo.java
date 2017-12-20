package com.pp.classBank;

import java.util.UUID;

class Person{
    public Person(){
        System.out.println("哇哇哇，出生了");
    }

    @Override
    protected void finalize() throws Throwable {  //finalize是Object类的方法，是在对象回收前调用的方法。
        System.out.println("下地狱了");
        throw new Exception("再活500年");
    }
}
public class SystemDemo {
    public static void main (String[] args){
        UUID uuid=UUID.randomUUID();
        System.out.println(uuid);
        Person p=new Person();
        p=null;
        System.gc();
        System.out.println("转世不为人");
    }
}
