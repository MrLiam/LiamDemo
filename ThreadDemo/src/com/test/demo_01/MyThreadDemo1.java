package com.test.demo_01;

import com.test.thread_01.MyThread1;

/*
 * 实现多线程有两种方式：
 * 		A:继承Thread类
 * 		B:实现Runnable接口
 * 
 * 	继承Thread类之后要重写run()方法，并启动线程
 * 
 * run()和start()方法区别？
 * 		run():封装了被线程执行的代码。
 * 		start():让线程启动，并由JVM调用run()方法。
 * 
 * public final String getName():获取线程名称。默认名称:Thread-编号，从0开始。
 * public final void setName(String name):更改线程名称
 * 
 * Thread(String name): 带参构造方法
 */
public class MyThreadDemo1 {

	public static void main(String[] args) {
		//MyThread1 thread1 = new MyThread1();
		//MyThread1 thread2 = new MyThread1();
		//默认名称 Thread-0 和  Thread-1
		//设置线程名
		//thread1.setName("刘林");
		//thread2.setName("liam");
		MyThread1 thread1 = new MyThread1("刘林");
		MyThread1 thread2 = new MyThread1("liam");
		thread1.start();
		thread2.start();
	}
	
}
