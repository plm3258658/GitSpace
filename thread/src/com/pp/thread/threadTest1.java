package com.pp.thread;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class threadTest1 implements Runnable {
	private String title;
	public threadTest1(String title){
		this.title=title;
	}
	@Override
	public void run() {
		for (int x=0;x<10;x++){
			System.out.println(this.title+",x="+x);
		}
	}
}
