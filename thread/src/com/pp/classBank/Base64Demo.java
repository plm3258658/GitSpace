package com.pp.classBank;



import java.util.Base64;

public class Base64Demo {
    public static void main(String[] args){
        String msg="www.163.com";
        String emsg=Base64.getEncoder().encodeToString(msg.getBytes());
        System.out.println(emsg);
        byte data[]=Base64.getDecoder().decode(emsg);
        System.out.println(new String(data));
    }
}
