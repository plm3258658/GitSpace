package com.pp.classBank;

public class RuntimeDemo {
    public static void main (String []args){
        Runtime run=Runtime.getRuntime();
        System.out.println("1max="+toMb(run.maxMemory()));
        System.out.println("1total="+toMb(run.totalMemory()));
        System.out.println("1free="+toMb(run.freeMemory()));
        String str="";
        for(int x=0;x<9999;x++){
            str+=x;
        }
        System.out.println("2max="+toMb(run.maxMemory()));
        System.out.println("2total="+toMb(run.totalMemory()));
        System.out.println("2free="+toMb(run.freeMemory()));
        run.gc();
        System.out.println("3max="+toMb(run.maxMemory()));
        System.out.println("3total="+toMb(run.totalMemory()));
        System.out.println("3free="+toMb(run.freeMemory()));
    }
    public static double toMb(long num){
        return (double)num/1024/1024;
    }
}
