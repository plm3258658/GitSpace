package com.pp.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 根据属性名称，调用对用类中的相应的getter/setter方法
 */
public class ObjectUtils {
    private ObjectUtils(){}

    /**
     * 负责调用制定类中的getter方法
     * @param wrapObject 要调用方法的所在类对象
     * @param attribute 属性名称
     * @return 调用对象的结果
     */
    public  static Object getObject(Object wrapObject,String attribute) throws  Exception{
        String methodName="get"+StringUtils.initCap(attribute);
        //调用指定属性的Field对象，目的是取得对象类型，如果没有此属性也就意味着无法继续了
//        Field field=wrapObject.getClass().getDeclaredField(attribute);
//        if(field==null){//本类中没有，从父类中查找
//            field=wrapObject.getClass().getField(attribute);
//        }
//        if(field==null){
//            return null;
//        }
        Field field=getObjectField(wrapObject, attribute);
        Method method=wrapObject.getClass().getMethod(methodName);
        if(method!=null){
//            return method.invoke(wrapObject);
            Object obj=method.invoke(wrapObject);
            if(obj ==null){//如果没有实例化对象，取得类对象的类型，并实例化对象
                obj=field.getType().newInstance();
                setObjectValue(wrapObject,attribute,obj);
            }
            return obj;
        }
        return null;
    }

    /**
     * 根据指定类对象设置类中属性，调用setter方法
     * @param wrapObject 属性所在类的实例化对象
     * @param attribute //属性名称
     * @param value 属性内容
     */
    public static void setObjectValue(Object wrapObject,String attribute,Object value)throws Exception{
//        Field field=wrapObject.getClass().getDeclaredField(attribute);
////        if(field==null){//本类中没有，从父类中查找
////            field=wrapObject.getClass().getField(attribute);
////        }
        Field field=getObjectField(wrapObject, attribute);
        if(field!=null){
            String methodName="set"+StringUtils.initCap(attribute);
            Method method=wrapObject.getClass().getMethod(methodName,field.getType());
            method.invoke(wrapObject,value);
        }
    }

    /**
     * 根据对象和指定属性名称取得相应Field对象信息
     * @param wrapObject 当前对象
     * @param attribute 属性
     * @return 属性对象，如果不存在返回null
     */
    public static Field getObjectField(Object wrapObject,String attribute) throws Exception{
        Field field=wrapObject.getClass().getDeclaredField(attribute);
        if(field==null){//本类中没有，从父类中查找
            field=wrapObject.getClass().getField(attribute);
        }
       return field;
    }
}
