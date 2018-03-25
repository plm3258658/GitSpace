package com.dataStructure.PATBasicLevel;

import java.util.Scanner;

/**
 * 1001
 *  害死人不偿命的(3n+1)猜想 (15)
 */
public class Topic1001 {
    public static void main(String[] args) {
        /**
         * 自解
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        int count=0;
        /**
         * 第一次
         */
//        for(;;){
//            if(n%2==1){
//                n=(n*3+1)/2;
//            }else{
//                n=n/2;
//            }
//            count++;
//            if(n==1) {
//                break;
//            }
//        }
        /**
         * 优化
         */
        while(n!=1){
            if(n%2==1){
                n=n*3+1;
            }
            n/=2;
            count++;
        }
        System.out.print(count);
    }
    /**
     * 柳婼解
     */
//    Scanner in = new Scanner(System.in);
//    int number = in.nextInt();
//		in.close();
//    int cnt = 0;
//		while (number != 1) {
//        if (number % 2 != 0) {
//            number = 3 * number + 1;
//        }
//
//        number /= 2;
//        cnt++;
//    }
//		System.out.println(cnt);
}
