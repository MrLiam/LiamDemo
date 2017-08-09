package com.udp.demo_02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * UDP协议接收数据步骤：
 * 1：创建接收端Socket服务对象
 * 2：创建一个数据包，用于接收数据
 * 3：接收数据
 * 4：解析数据，并显示在控制台
 * 5：释放资源 
 * 
 */

public class ReceiveDataByUDPDemo {

	public static void main(String[] args) throws IOException {
		//创建接收端Socket服务对象，并且指定端口号
		DatagramSocket ds = new DatagramSocket(10086);
		//创建一个数据包，用于接收数据
		byte[] bys = new byte[1024];//根据数据多少定义
		DatagramPacket dp = new DatagramPacket(bys, bys.length);
		
		//接收数据
		ds.receive(dp);//没接收到数据，一直阻塞
		
		InetAddress address = dp.getAddress();
		String ip = address.getHostAddress();
		//返回缓冲区
		byte[] buff = dp.getData();
		//返回数据长度
		int len = dp.getLength(); 
		String s = new String(buff, 0, len);
		System.out.println("发送端Ip是 --"+ip+":   "+s);
		
		//释放资源
		ds.close();
	}

}
