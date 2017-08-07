package com.test.demo_01;

import com.test.thread_01.MyRunnable;

/*
 * 实现Runnable接口的方式：
 * 		A:自定义类实现MyRunnable实现Runnable接口
 * 		B:重写run()方法。
 * 		C:创建自定义类的对象
 * 		D:创建Thread类的对象，把MyRunnable类的对象作为构造参数传递
 * 		E:调用Thread类的start()方法即可。
 */
public class MyRunnableDemo {
	public static void main(String[] args) {
		MyRunnable my = new MyRunnable();
		
		//Thread t1 = new Thread(my);
		//Thread t2 = new Thread(my);
		//t1.setName("线程一");
		//t2.setName("线程二");
		//方式二
		Thread t1 = new Thread(my,"令狐冲");
		Thread t2 = new Thread(my,"任盈盈");
		t1.start();
		t2.start();
	}
}
