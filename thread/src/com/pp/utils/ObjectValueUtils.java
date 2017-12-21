package com.pp.utils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 本类的功能是将字符串的内容根据属性对应的类型变为各种数据类型
 * 支持的类型：int(Integer)/double(Double)/long(Long)/String/Date
 * 其中Date 必须考虑同时支持有日期的时间(yyyy-MM-dd HH:mm:ss)/日期(yyyy-MM-dd)
 */
public class ObjectValueUtils {
    private ObjectValueUtils(){}

    /**
     * 负责将传入的字符串变为指定属性类型相符合的数据类型
     * @param wrapObject 要操作的对象
     * @param attribute 属性类型
     * @param value 传入的数据
     * @return  根据数据类型进行转型处理
     */
    public static Object getValue(Object wrapObject,String attribute,String value)throws  Exception{
        Field field=ObjectUtils.getObjectField(wrapObject,attribute);
        if(field==null){
            return null;
        }
        return stringToType(field.getType().getSimpleName(),value);
    }

    /**
     * 根据指定类型将字符串进行转型处理
     * @param type 指定的类型
     * @param value 传入的字符串
     * @return 转换好的值
     */
    public static Object stringToType(String type,String value){
        if(isNotEmpty(value)){
            if("String".equals(type)){
                return value;
            }else if("int".equals(type) || "Integer".equals(type)){
                if(isInt(value)){
                    return Integer.parseInt(value);
                }
            }else if("double".equals(type) || "Double".equals(type)){
                if(isDouble(value)){
                    return Double.parseDouble(value);
                }
            }else if("long".equals(type) || "Long".equals(type)){
                if(isInt(value)){
                    return Long.parseLong(value);
                }
            }else if("Date".equals(type)){
                String pattern=null;
                if(isDate(value)){
                    pattern="yyyy-MM-dd";
                }else if(isDateTime(value)){
                    pattern="yyyy-MM-dd hh:mm:ss";
                }
                if(pattern!=null){
                    try {
                        return new SimpleDateFormat(pattern).parse(value);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    /**
     * 判断字符串是否为空，不为空才进行处理
     * @param str 要判断的字符串
     * @return 为空返回false，不为空true
     */
    private static boolean isNotEmpty(String str){
        return !(str==null || str.isEmpty() || "".equals(str));
    }

    /**
     * 判断给定字符串是否为一个整数
     * @param str 要判断的字符串
     * @return 如果是整数返回true，否则false
     */
    private static boolean isInt(String str){
        if(isNotEmpty(str)){
            return str.matches("\\d+");
        }
        return false;
    }

    /**
     * 判断给定的字符串是否为一个小数
     * @param str
     * @return  如果是小数返回true，否则false
     */
    private static boolean isDouble(String str){
        if(isNotEmpty(str)){
            return str.matches("\\d+(\\.\\d+)?");
        }
        return false;
    }
    /**
     * 判断给定的字符串是否为一个日期(yyyy-MM-dd)
     * @param str
     * @return  如果是日期返回true，否则false
     */
    private static boolean isDate(String str){
        if(isNotEmpty(str)){
            return str.matches("\\d{4}-\\d{2}-\\d{2}");
        }
        return false;
    }
    /**
     * 判断给定的字符串是否为一个日期(yyyy-MM-dd hh:mm:ss)
     * @param str
     * @return  如果是日期返回true，否则false
     */
    private static boolean isDateTime(String str){
        if(isNotEmpty(str)){
            return str.matches("\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}");
        }
        return false;
    }

}
