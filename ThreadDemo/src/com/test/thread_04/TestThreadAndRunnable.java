package com.test.thread_04;

public class TestThreadAndRunnable {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello,");
				
			}
		}){
			@Override
			public void run() {
				System.out.println("world!");
			}
		}.start();//运行结果：   world!
	}
}
