package com.pp.thread;

public class threadTest1 implements Runnable {
	int i=0;
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		System.out.println(i++);
		System.out.println(i);
	}
	
}
