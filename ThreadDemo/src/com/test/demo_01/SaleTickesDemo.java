package com.test.demo_01;

import com.test.thread_01.TicketDemo;

/*
 * 售票方法
 * 
 * 线程是共享进程的资源。
 * 一个Java应用程序是一个进程。
 * 		栈  	是每个线程都有自己的一份
 * 		堆	共享的
 * 		方法区	共享的
 * 
 * 问题：
 * 	A：把int tickets = 100;放到run()都会重新定义100张票。
 * 		每个线程都有自己的栈空间，那么，每个线程对象也就会拥有自己的100张票。
 * 	B：把private int tickets = 100;定义到了成员位置，还是会有问题。
 * 		原因：创建了四个对象，而普通的成员变量是每个对象所特有的，也就是说每个线程对象还是拥有自己的
 * 			100张票。
 * 		目的是，这四个线程共同拥有100张票。怎么实现？
 * 		加static
 * 
 */
public class SaleTickesDemo {

	public static void main(String[] args) {
		TicketDemo s1 = new TicketDemo("窗口一");
		TicketDemo s2 = new TicketDemo("窗口二");
		TicketDemo s3 = new TicketDemo("窗口三");
		TicketDemo s4 = new TicketDemo("窗口四");
		s1.start();
		s2.start();
		s3.start();
		s4.start();
	}

}
