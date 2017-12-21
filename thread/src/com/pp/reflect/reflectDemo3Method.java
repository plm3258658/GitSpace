package com.pp.reflect;

import java.lang.reflect.Method;

class Person2{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class reflectDemo3Method {
    public static void main(String[] args) throws  Exception{
        String attribute="name";
        String value="PP";
//        Class<?> cls=Person2.class;
        Class<?> cls=Class.forName("com.pp.reflect.Person2");
        Object obj=cls.newInstance();
//        Method met[]=cls.getMethods();
//        for(Method m:met){
//            System.out.println(m);
//        }
        Method setMethod=cls.getMethod("set"+initcap(attribute),String.class);//获取并设置get方法
        setMethod.invoke(obj,value);//相当于：对象.setName(value);
        Method getMethod=cls.getMethod("get"+initcap(attribute));//获取并设置get方法
        System.out.print(getMethod.invoke(obj));
    }
    public static String initcap(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
