package com.test.demo_01;

import com.test.thread_01.TicketsDemo2;

/*
 * 多线程程序出现安全问题的原因：
 * 	A: 是多线程程序。
 * 	B: 有共享数据。
 *  C: 针对共享数据有多条语句操作。
 *  
 *  改进程序？
 *  	只需要把多线程环境中，操作共享数据的操作给变成单线程的就没有问题了。
 *  	Java 针对这种情况，就提供了同步技术：同步代码块。
 *  		格式：
 *  			synchronized(对象){
 *  				需要被同步的代码。
 *  			}
 *  		A: 对象？
 *  			如果不知道用哪个对象，就用Object 对象。
 *  		B: 需要被同步的代码？
 *  			那些代码导致出现了问题，就把哪些代码同步起来。
 *  	
 *  	那些代码会出问题？
 *  		有共享数据
 *  		针对共享数据有多条语句操作。
 *  
 *  加入同步后，居然还有问题，为什么呢？
 *  	同步代码块中的对象针对多个线程必须是同一个。
 *  	其实这个对象被称为同步锁对象。
 *  
 *   同步锁种类：
 *   	同步代码块锁对象：
 *   		任意对象
 *   	同步方法锁对象：
 *   		this对象
 *   	静态方法锁对象：
 *   		类锁   当前类的字节码文件对象 
 */

public class SaleTicketsDemo3 {
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
