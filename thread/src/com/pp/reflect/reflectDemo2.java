package com.pp.reflect;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

//
class person implements IMessage,IFruit{
    public void print(){};
    public void eat(){};
}
class Persons{
    public Persons()throws NullPointerException,RuntimeException,ClassCastException{}
    public Persons(String name)throws NullPointerException,RuntimeException,ClassCastException{}
    public Persons(String name,int age)throws NullPointerException,RuntimeException,ClassCastException{}
}
public class reflectDemo2 {
    public static void main(String[] args)throws Exception{
        //获取父类信息
//        Class<?> cls=person.class;
//        System.out.println(cls.getClass().getName());
//        System.out.println(cls.getClass().getSuperclass().getName());
//        for(Class<?> s:cls.getInterfaces()){
//            System.out.println(s);
//        }
        //获取构造方法
        Class<?> cls1=Persons.class;
        Constructor<?> conts[]=cls1.getConstructors();
        for(Constructor<?> s:cls1.getConstructors()){
            System.out.println(Modifier.toString(s.getModifiers()));
//            System.out.println(s);
            System.out.print(s.getName()+"(");
            Class<?> paramTypes[]=s.getParameterTypes();
            for(Class<?> a:paramTypes){
                System.out.print(a.getName()+",");
            }
            System.out.print(")");
            Class<?> exps[]=s.getExceptionTypes();
            if(exps.length>0){
                System.out.print("throws  ");
                for(Class<?> e:exps){
                    System.out.print(e.getName()+",");
                }
                System.out.print(")");
            }
            System.out.println();
        }
    }
}
