package com.test.thread_03;

public class DeadLockDemo {
	public static final Object objA = new Object();
	public static final Object objB = new Object();
	
	public static void main(String[] args) {
		DeadThread d = new DeadThread(true);
		DeadThread d2 = new DeadThread(false);
		d.start();
		d2.start();
		
		
	}
}
