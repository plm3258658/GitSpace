package com.pp.thread;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("hello world");
			threadTest1 mt1=new threadTest1("1");
			threadTest1 mt2=new threadTest1("2");
			threadTest1 mt3=new threadTest1("3");
			new Thread(mt1).start();
			new Thread(mt2).start();
			new Thread(mt3).start();
			//内部函数
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("Hello World!");
				}
			}).start();
			//lambda
			new Thread(()-> System.out.println("Hello World ! 2")).start();
	}

}
