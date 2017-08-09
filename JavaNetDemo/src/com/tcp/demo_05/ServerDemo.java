package com.tcp.demo_05;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) throws IOException {
		//创建接收数据的Socket对象
		ServerSocket ss = new ServerSocket(10001);
		
		//监听客户端连接
		//		等待客户端的连接
		Socket s = ss.accept();//阻塞式
		
		//获取Socket对象的输入流
		InputStream is = s.getInputStream();
		
		//读取数据，并显示在控制台
		byte[] buf = new byte[1024];
		int len = is.read(buf);
		String data = new String(buf, 0, len);
		System.out.println("data: "+data);
		
		//释放资源
		s.close();
		ss.close();
	}

}
