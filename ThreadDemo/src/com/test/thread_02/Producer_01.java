package com.test.thread_02;

import com.bean.Products;

/*
 * 生产者类
 *   负责生产商品
 */
public class Producer_01 implements Runnable {
	
	private Products pd;
	
	
	public Producer_01(Products pd) {
		this.pd = pd;
	}
	

	@Override
	public void run() {
		while(true){
			synchronized (pd) {
				if(pd.getProducts()>10){
					try {
						pd.wait();//让线程等待，下次从此处开始执行
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					pd.setProducts(pd.getProducts()+1);//生产一个产品
					pd.notify();//唤醒线程，并不代表线程要马上执行
				}
				System.out.println("生产者生产的产品数为 --- "+pd.getProducts());
			}
		}
		
	}

}
