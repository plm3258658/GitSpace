package com.pp.utils;

/**
 * 字符串处理
 *
 */
public class StringUtils {
    private StringUtils(){}

    /**
     * 返回字符串首字母大写
     * @param str
     * @return
     */
    public static  String initCap(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
