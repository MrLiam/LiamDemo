package com.test.demo_02;

import com.bean.Products;
import com.test.thread_02.Consume_01;
import com.test.thread_02.Producer_01;

public class ProducerAndConsumerDemo_01 {
	
	public static void main(String[] args) {
		Products pd = new Products();
		Producer_01 pdc = new Producer_01(pd);
		Consume_01 cm = new Consume_01(pd);
		
		Thread t1 = new Thread(pdc);
		Thread t2 = new Thread(cm);
		
		t1.start();
		t2.start();
	}
}
