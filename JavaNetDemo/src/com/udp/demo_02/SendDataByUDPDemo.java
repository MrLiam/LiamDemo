package com.udp.demo_02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDataByUDPDemo {
	
	public static void main(String[] args) throws IOException {
		//创建发送端Socket服务对象
		DatagramSocket ds = new DatagramSocket();
		
		//创建数据并打包
		byte[] bys = "测试发送数据，通过UDP发送".getBytes();
		int len = bys.length;
		InetAddress address = InetAddress.getByName("127.0.0.1");
		int port = 10086;
		DatagramPacket p = new DatagramPacket(bys, len, address, port);
		//通过socket对象的发送功能发送数据包
		ds.send(p);
		//释放资源
		ds.close();
	}
}
