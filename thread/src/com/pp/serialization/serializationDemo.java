package com.pp.serialization;


import java.io.*;

/**
 * 所谓的对象序列化就是将内存中保存的对象变为二进制数据流的形式进行传输，或保存在文本中
 *  但是并不意味着所有类的对象都可以被序列化，严格来说，需要被序列化的类往往需要传输使用
 *  同时这个类必须实现java.io.Serializable接口。但是这个接口并没有方法定义，只是一个标识接口
 *
 * 序列化对象时所需要保存的是对象中的属性，所以默认情况下类对象的属性将被转为二进制数据流存在
 *
 * ------------------------------------------------
 * 序列化与反序列化
 * java.io包中的两个类：ObjectOutputStream/ObjectInputStream
 *-------------------------------------------------
 * transient关键字
 *
 *
 */

class Person implements Serializable{
    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class serializationDemo {
    public static final File file=new File("D:"+File.separator+"person.ser");
    public static void main(String[] args) throws Exception{
//        ser(new Person("张三",20));
        dser();
    }
    public static void ser(Object obj)throws Exception{ //专门负责实例化对象
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(obj);
        oos.close();
    }
    public static void dser()throws Exception{ //专门负责实例化对象
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
        System.out.println(ois.readObject());
        ois.close();
    }
}
