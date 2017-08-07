package com.test.thread_01;

/*
 * 现有一百张票，同时四个窗口出售
 *	问题：
 * 	A：把int tickets = 100;放到run()都会重新定义100张票。
 * 		每个线程都有自己的栈空间，那么，每个线程对象也就会拥有自己的100张票。
 * 	B：把private int tickets = 100;定义到了成员位置，还是会有问题。
 * 		原因：创建了四个对象，而普通的成员变量是每个对象所特有的，也就是说每个线程对象还是拥有自己的
 * 			100张票。
 * 		目的是，这四个线程共同拥有100张票。怎么实现？
 * 		加static
 * 
 */
public class TicketDemo extends Thread {
	private static int tickets = 100;
	
	public TicketDemo(){
	}
	
	public TicketDemo(String name){
		super(name);
	}
	
	@Override
	public void run() {
		while(true){
			if(tickets>0){
				System.out.println(getName()+"正在出售第 "+(tickets--)+" 张票！");
			}else{
				break;
			}
		}
		
	}
	
	
	
}
