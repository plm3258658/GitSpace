package com.pp.classBank;

import java.util.Arrays;

/**
 * 比较器
 * 基本比较器：comparable
 *
 *
 */

class Person1 implements Comparable<Person1>{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person1(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person1 o) {
        if(this.age>o.age){
            return 1;
        }else if(this.age<o.age) {
            return -1;
        }else{
            return 0;
        }
    }
}

public class ComparableDemo {
    public static void main(String[] args)throws Exception{
        Person1 per[]=new Person1[]{
                new Person1("张三",10),
                new Person1("李四",11),
                new Person1("王五",9)
        };
        Arrays.sort(per);
        System.out.println(Arrays.toString(per));
    }
}
