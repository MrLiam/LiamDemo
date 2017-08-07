package com.test.thread_03;

public class DeadThread extends Thread {
	private boolean flag;
	
	public DeadThread(boolean flag){
		this.flag = flag;
	}
	
	@Override
	public void run() {
		if(flag){
			synchronized (DeadLockDemo.objA) {
				System.out.println("If Block A");
				synchronized (DeadLockDemo.objB) {
					System.out.println("If Block B");
				}
			}
		}else{
			synchronized (DeadLockDemo.objB) {
				System.out.println("Else Lock B");
				synchronized (DeadLockDemo.objA) {
					System.out.println("Else Lock A");
				}
			}
		}
	}
}
