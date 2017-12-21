package com.pp.reflect;

import java.lang.reflect.Field;

class Person3{
    private String name;
}
//class Student extends  Person3{
//    private String school;
//}
public class reflectDemo4Member {
    public static void main(String[] args)throws Exception{
//        Class<?> cls=Class.forName("com.pp.reflect.Student");
//        {
//            Field[] fields=cls.getFields();
//            for(Field field:fields){
//                System.out.println(field);
//            }
//        }
//        System.out.print("-");
//        {
//            Field[] fields=cls.getDeclaredFields();
//            for(Field field:fields){
//                System.out.println(field);
//            }
//        }
        Class<?> cls=Class.forName("com.pp.reflect.Person3");
        Object obj=cls.newInstance();
        Field nameField=cls.getDeclaredField("name");//操作name属性
        /*nameField.setAccessible(true);//取消封装，使private属性可以被访问到
        nameField.set(obj,"张三");//等价于：对象.name="张三"
        System.out.print(nameField.get(obj));//取得属性*/
        //绝大部分情况下属性还是需要setter和getter方法，不会使用如上setAccessible方法。
        // 因为需要给用户操作属性的功能
        System.out.println(nameField.getType().getName());//带包名
        System.out.println(nameField.getType().getSimpleName());//不带包名

    }
}
