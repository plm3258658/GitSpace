package com.pp.reflect;

import java.util.Date;

public class reflectDemo {
    public static void main(String[] args) throws Exception{
//        Class<?> cls=new Date().getClass();//第一种class类的产生方式（只有这种会产生实例化）
//        Class<?> cls=Date.class;//第二种class类的产生方式
        Class<?> cls=Class.forName("java.util.Date");//第三种class类的产生方式
        Object obj=cls.newInstance();//实例化对象，等价 new String();
        System.out.println(cls.getName());
        System.out.println(obj);
    }
}
