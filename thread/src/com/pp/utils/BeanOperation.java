package com.pp.utils;

/**
 * 本类主要负责实现自动vo匹配处理操作，本身不需要实例化对象
 * 所以构造方法私有化
 */
public class BeanOperation {
    private BeanOperation(){}

    /**
     * 负责设置类中的属性操作
     * @param actionObject 表示当前发出设置请求的程序类的当前对象
     * @param msg 属性的具体内容，格式”属性名：内容|属性名：内容|..“
     */
    public static void setBeanValue(Object actionObject,String msg)throws  Exception{
        //如果想进行内容的设置，那么必须要求将字符串拆分
        String[] result=msg.split("\\|");//分割各个属性与值的组合
            for(int i=0;i<result.length;i++){
                String[] temp=result[i].split(":",2);//分割属性和值
//                String attribute[]=temp[0].split(".");

                String attribute=temp[0];//属性

                String  value=temp[1];//属性对应的值

                String[] fields=attribute.split("\\.");
                if(fields.length>2){
                    //多级vo
                    Object currentObject=actionObject;//传进来的默认的vo
                    for(int j=0;j<fields.length-1;j++){//不断循环取下一级的实体
                        currentObject=ObjectUtils.getObject(currentObject,fields[j]);
                    }
                    Object values=ObjectValueUtils.getValue(currentObject,fields[fields.length-1],value);
                    ObjectUtils.setObjectValue(currentObject,fields[fields.length-1],values);
                }else{
                    //单级vo
                    Object currentObj=ObjectUtils.getObject(actionObject,fields[0]);
                    Object values=ObjectValueUtils.getValue(currentObj,fields[1],value);
                    ObjectUtils.setObjectValue(currentObj,fields[1],values);
                }

//                System.out.println(currentObj);
            }
    }
}
