package com.test.demo_01;

import com.test.thread_01.TicketsDemo2;

/*
 * 实现Runnable接口改进买票程序。
 * 
 * 	程序再次出现问题：
 * 	A: 相同的票卖了多次。
 * 		cpu的每一次执行，必须是一个原子性的操作，这个操作是不能再分割的。
 * 			int i = 10； 其实是两个原子性的操作。
 * 			这样的话，tickets-- 其实也不是一个原子性的操作。
 * 			可能在操作的中间部分，被其他的线程给执行了。这样就会有哦相同的票执行了多次。
 * 
 * 	B: 出现了负数票的情况。
 * 		因为线程的随机性
 */

public class SaleTicketsDemo2 {
	public static void main(String[] args) {
		TicketsDemo2 ticket = new TicketsDemo2();
		 Thread t1 = new Thread(ticket,"窗口一");
		 Thread t2 = new Thread(ticket,"窗口二");
		 Thread t3 = new Thread(ticket,"窗口三");
		 Thread t4 = new Thread(ticket,"窗口四");
		 t1.start();
		 t2.start();
		 t3.start();
		 t4.start();
	}
}
