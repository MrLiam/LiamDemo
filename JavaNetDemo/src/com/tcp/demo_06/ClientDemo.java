package com.tcp.demo_06;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * 向服务器发送数据，并接收服务器返回数据，显示到控制台
 */
public class ClientDemo {

	public static void main(String[] args) throws IOException {
		// 创建客户端Socket对象
		Socket s = new Socket("192.168.0.40", 10001);

		// 获取输出流
		OutputStream os = s.getOutputStream();
		os.write("我是客户端发过来的数据哦".getBytes());

		// 获取服务器返回数据
		InputStream is = s.getInputStream();
		byte[] buff = new byte[1024];
		int len = is.read(buff);
		String data = new String(buff, 0, len);
		System.out.println("client: " + data);
		
		//释放资源
		s.close();

	}

}
