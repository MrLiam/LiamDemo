package com.test.thread_01;

import java.util.concurrent.locks.ReentrantLock;

public class TicketsDemo3Lock implements Runnable{
	private final ReentrantLock lock = new ReentrantLock();
	private int tickets = 100;
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lock.lock();
			if(tickets>0){
				System.out.println(Thread.currentThread().getName() +"正在出售第  "+(tickets--)+" 张票");
			}else{
				break;
			}
			lock.unlock();
		}
	}
}
