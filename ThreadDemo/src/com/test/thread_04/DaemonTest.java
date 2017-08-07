package com.test.thread_04;

public class DaemonTest {

	public static void main(String[] args) {
		MyThread t1 = new MyThread("父亲");
		MyThread t2 = new MyThread("儿子");
		MyThread t3 = new MyThread("女儿");
		//设置守护线程,如果程序只有守护线程在运行，那么JVM会自动退出
		t1.setDaemon(true);
		t2.setDaemon(true);
		t3.setDaemon(true);
		t1.start();
		try {
			t1.join();//join作用就是 其他线程等待当前线程执行完才能继续执行
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
		t2.start();
		for(int i =0;i<50;i++){
			System.out.println(Thread.currentThread().getName()+"--"+i);
		}
	}
}
