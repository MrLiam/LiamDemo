package com.test.thread_02;

import com.bean.Products;

/*
 * 消费者类
 * 		消费产品
 */
public class Consume_01 implements Runnable {

	private Products pd;
	
	public Consume_01(Products pd) {
		this.pd = pd;
	}
	
	@Override
	public void run() {
		while(true){
			synchronized (pd) {
				if(pd.getProducts()<0){
					try {
						pd.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					//消费者消费
					pd.setProducts(pd.getProducts()-1);
					pd.notify();
				}
				System.out.println("剩余产品数是   "+pd.getProducts());
			}
		}
	}

}
