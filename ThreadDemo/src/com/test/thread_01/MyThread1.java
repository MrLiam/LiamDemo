package com.test.thread_01;

public class MyThread1 extends Thread {
	public  MyThread1() {
		super();
	}
	
	public MyThread1(String name){
		super(name);
	}
	
	@Override
	public void run() {
		for(int i=0; i < 100; i++){
			System.out.println(getName()+"  "+i);
		}
	}
}
