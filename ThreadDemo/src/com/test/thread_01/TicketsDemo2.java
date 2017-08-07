package com.test.thread_01;

public class TicketsDemo2 implements Runnable{
	private int tickets = 100;
	private Object obj = new Object();
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(obj){
				if(tickets>0){
					System.out.println(Thread.currentThread().getName() +"正在出售第  "+(tickets--)+" 张票");
				}else{
					break;
				}
			}
		}
	}
}
