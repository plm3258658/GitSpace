package com.dataStructure.PATBasicLevel;

import java.util.Scanner;

public class Topic1003 {
    /**
     * 1003
     *
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.next();
        input.close();
        int count=8;
        boolean p=false;
        boolean a=false;
        boolean t=false;
        int A=0;
        for(int i=0;i<count;i++){
            if(i>=str.length()) break;
            if(i==0){
                if(str.charAt(i)=='A'){
                    A=1;
                    continue;
                }
            }else if(i==count-1){
                if(A==1 && str.charAt(i)!='A'){
                    A=2;
                    continue;
                }
            }
            switch (str.charAt(i)){
                case 'P':
                    p=true;
                    break;
                case 'A':
                    a=true;
                    break;
                case 'T':
                    t=true;
                    break;
                 default:
                     A=2;
                     break;
            }
        }
        if(p && a && t && A<2){
            System.out.println("答案正确");
        }else if(A>1){
            System.out.println("答案错误");
        }
    }
}
