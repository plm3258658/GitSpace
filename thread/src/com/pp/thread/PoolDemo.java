package com.pp.thread;

import java.util.concurrent.*;

public class PoolDemo {
    public static void main(String[] args) throws  Exception{
//        ExecutorService executorService= Executors.newCachedThreadPool();//无限大小的线程池
//        ExecutorService executorService= Executors.newSingleThreadExecutor();//单例线程池
//        ExecutorService executorService= Executors.newFixedThreadPool(3);//固定大小线程池
        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(1);//定时调度池
        for(int x=0;x<10;x++){
//            Thread.sleep(200);
            int index =x;
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            });
//            executorService.submit(() -> {
//               System.out.println(Thread.currentThread().getName()+"/x="+index);
//            });
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"/x="+index);
                }
            },3,2, TimeUnit.SECONDS);//3秒后开始执行，每2秒执行一次
        }
//        executorService.shutdown();//定时线程池时，不关闭
    }
}
