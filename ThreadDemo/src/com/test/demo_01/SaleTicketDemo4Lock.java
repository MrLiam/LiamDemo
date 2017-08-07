package com.test.demo_01;


import com.test.thread_01.TicketsDemo3Lock;

public class SaleTicketDemo4Lock {
	
	public static void main(String[] args) {
		TicketsDemo3Lock ticket = new TicketsDemo3Lock();
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
