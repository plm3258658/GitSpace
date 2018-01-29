package com.study.dataStructure;

import java.util.Scanner;

public class Test1BeforeStudy {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        StringBuffer sb=new StringBuffer(input.nextLine());
        String[] str1=sb.toString().split("\\s+");
        int sum=Integer.parseInt(str1[0]);
        String symbol=str1[1];
        int a=0;
        int residue=0;
        int b=0;
        if(sum>0 && sum<=1000){
            for(int i=1;i<=1000;i+=2){
                b++;
                if(i==1){
                    if(sum<=i){
                        a=i;
                        break;
                    }
                }else if(i>1){
                    if(sum<i*b+b-1){
                        a=i-2;
                        break;
                    }else if((sum==i*b+b-1)){
                        a=i;
                        break;
                    }
                }
            }
            if(a==1){
                residue=sum-1;
            }else{
                residue=sum-(a*(a+1)/2+(a-1)/2);
            }
            for(int i=1;i<=a;i++){
                if(i==1 || i==a){
                    for(int s=1;s<=a;s++){
                        System.out.print(symbol);
                    }
                }else if(i<=(a+1)/2){
                    for(int z=1;z<=i-1;z++){
                        System.out.print(" ");
                    }
                    for(int x=1;x<=a-(i-1)*2;x++){
                        System.out.print(symbol);
                    }
                    for(int c=1;c<=i-1;c++){
                        System.out.print(" ");
                    }
                }else if(i>(a+1)/2){
                    for(int z=1;z<=(a-i);z++){
                        System.out.print(" ");
                    }
                    for(int x=1;x<=(i-(a+1)/2)*2+1;x++){
                        System.out.print(symbol);
                    }
                    for(int c=1;c<=(a-i);c++){
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
        System.out.println(residue);
    }
}
