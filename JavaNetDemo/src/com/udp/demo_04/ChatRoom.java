package com.udp.demo_04;

import java.io.IOException;
import java.net.DatagramSocket;

/*
 * 利用多线程实现同一控制台显示和发送数据
 */
public class ChatRoom {

	public static void main(String[] args) throws IOException{
		DatagramSocket dsSend = new DatagramSocket();
		DatagramSocket dsReceive = new DatagramSocket(10000);
		
		SendThread st = new SendThread(dsSend);
		ReceiveThread rt = new ReceiveThread(dsReceive);
		
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(rt);
		
		t1.start();
		t2.start();
	}

}
