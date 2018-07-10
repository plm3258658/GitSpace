package com.pp.test;

import java.util.Arrays;

public class testDemo {
    public static void main(String[] args) throws Exception {
//        String a="123\n456\t";
//        String b="123\n456\t123\n456\t";
//        String c=b.substring(a.length()-1);
//        c=a+"修改后：\n"+c;
//        System.out.println(c);
//        String filename="Adidas_20180508.xlsx";
//        if(filename.indexOf(".")>0) {
//            filename =new StringBuffer().append(filename.substring(0, filename.indexOf("."))+"_")
//                    .append(1).append(filename.substring(filename.indexOf("."))).toString();
//        }
//        System.out.println(filename);
//        System.out.println(add(1));
    }
    static int add(int i){
        ++i;
        if(i<=10){
            i=add(i);
        }
        return i;
    }

    static String encrypt(){
        return null;
    }
    static String decode(){
        return null;
    }
}
