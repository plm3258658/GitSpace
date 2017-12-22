package com.pp.classBank;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args){
        Stack<String> all=new Stack<String>();
        all.push("A");
        all.push("B");
        all.push("C");
        System.out.println(all.pop());
        System.out.println(all.pop());
        System.out.println(all.pop());
        System.out.println(all.pop());
    }
}
