package com.test.thread_01;

/*
 * 针对实现接口的这种方式，没有办法获取名字，所以，JAVA提供了一个静态方法，获取当前正在执行的线程对象。
 * public static Thread currentThread() 
 */
public class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int x =0;x<100;x++){
			System.out.println(Thread.currentThread().getName()+" "+x);
		}
	}

}
