package com.pp.superclass;
class point<T>{  //T代表一个参数，表示一个占位符，其他符号也可，数量也可变
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}
class Msg<T extends Number>{
    private T note;

    public T getNote() {
        return note;
    }

    public void setNote(T note) {
        this.note = note;
    }
}
class Msg1<T>{
    private T note;

    public T getNote() {
        return note;
    }

    public void setNote(T note) {
        this.note = note;
    }
}
public class superclass {
    public static  void main(String[] args){
        point<String> p =new point<>();
        p.setX("abc");
        p.setY("dbc");
        System.out.println("x="+p.getX()+"/y="+p.getY());
        fun(p);
        Integer data[]=fun3(1,2,3,4);
        for(int temp:data){
            System.out.println(temp);
        }
    }
    public static void fun(point<?> p){ // "?"接受任意的泛型类型，并让用户不能修改。"?"是通配符。
        //当接受类型不确定但又需要接受各种类型的时候使用
        //? extends 类：设置泛型上限
        //例如:? extends Number ，表示只能设置Number子类如：Integer,Double
        //? super 类：设置泛型下限
        //例如：? super Stirng，表示只能设置String或其父类Object
        int i=123;
//        p.setX(i);
//        p.setY(i);
        System.out.println(p.getX()+"/"+p.getY());
    }

    public static void fun1(Msg<? extends Number> msg){

    }
    public static void fun2(Msg1<? super String> msg){

    }
    public static <T> T[ ] fun3(T ... args){ //泛型方法
        return args;
    }
}
