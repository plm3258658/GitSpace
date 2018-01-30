package com.dataStructure.PATBasicLevel;

import java.util.Scanner;

/**
 * 1027
 * 打印沙漏
 */
public class Topic1027 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n = input.nextInt();
        char symbol = input.next().charAt(0);
        input.close();
//        StringBuffer sb=new StringBuffer(input.nextLine());
//        String[] str1=sb.toString().split("\\s+");
//        int sum=Integer.parseInt(str1[0]);
//        String symbol=str1[1];
        int a=0;
        int residue=0;
        int b=0;
        if(n>0 && n<=1000){
            for(int i=1;i<=1000;i+=2){
                b++;
                if(i==1){
                    if(n<=i){
                        a=i;
                        break;
                    }
                }else if(i>1){
                    if(n<i*b+b-1){
                        a=i-2;
                        break;
                    }else if((n==i*b+b-1)){
                        a=i;
                        break;
                    }
                }
            }
            if(a==1){
                residue=n-1;
            }else{
                residue=n-(a*(a+1)/2+(a-1)/2);
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
    /**
     * 网上实现
     * https://github.com/JoyHwong/PAT-Solutions/blob/master/Java/Basic/basicLevel1027/Main.java
     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        char c = in.next().charAt(0);
//        in.close();
//
//        int w = (int) Math.sqrt((n + 1) / 2);
//        for (int i = 0; i < 2 * w - 1; i++) {
//            for (int j = 0; j < 2 * w - 1; j++) {
//                if ((i > j && i + j < 2 * w - 2) || (i < j && i + j > 2 * w - 2)) {
//                    if (i > j && i + j < 2 * w - 2)
//                        System.out.print(" ");
//                } else {
//                    System.out.print(c);
//                }
//            }
//
//            System.out.println();
//        }
//
//        System.out.println(n - 2 * w * w + 1);
//    }

}
