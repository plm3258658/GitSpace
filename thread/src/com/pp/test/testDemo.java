package com.pp.test;

public class testDemo {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("123");
            throw new Exception();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
