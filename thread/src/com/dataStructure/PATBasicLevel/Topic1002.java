package com.dataStructure.PATBasicLevel;

import java.util.Scanner;

/**
 * 1002
 * 写出这个数
 * Character.getNumericValue();
 * 传入char，返回对应的int数组，否则取出的是对应字符的ASCII码值
 */
public class Topic1002 {
    public static void main(String[] args) {
        String[] array={"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
        Scanner input=new Scanner(System.in);
        String str=input.next();
        Integer sum=0;
        for(int i=0;i<str.length();i++){
            sum+= Character.getNumericValue(str.charAt(i));
        }
        String sumStr=sum.toString();
        for(int i=0;i<sumStr.length();i++){
            System.out.print(array[Character.getNumericValue(sumStr.charAt(i))]);
            System.out.print(" ");
        }
    }
}
