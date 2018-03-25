package com.dataStructure.PATBasicLevel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1008
 * 数组元素循环右移的问题
 */
public class Topic1008 {
    public static void main(String[] args) {
        Scanner input1=new Scanner(System.in);
        StringBuffer sb1=new StringBuffer(input1.nextLine());
        String[] strArray1=sb1.toString().split("\\s+");
        int count=Integer.parseInt(strArray1[0]);
        int location=Integer.parseInt(strArray1[1]);
        Scanner input2=new Scanner(System.in);
        StringBuffer sb2=new StringBuffer(input2.nextLine());
        String[] strArray2=sb2.toString().split("\\s+");
        ArrayList ints=new ArrayList();
        for(int i=0;i<strArray2.length;i++){
            ints.add(strArray2[i]);
        }
        int size=ints.size();
        for(int i=0;i<location;i++){
            ints.add(ints.get(size-location+i));
        }
        for(int i=size-1;i>=location;i--){
            ints.set(i,ints.get(i-location));
        }
        for(int i=0;i<location;i++){
            ints.set(i,ints.get(size+i));
        }
        for(int i=0;i<location;i++){
            ints.remove(ints.size()-1);
        }
        for(int i=0;i<ints.size();i++){
            System.out.print(ints.get(i));
            System.out.print(" ");
        }
    }
}
