package com.tcp.demo_06;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 接收客户端数据，并反馈信息给客户端
 */
public class ServerDemo {

	public static void main(String[] args) throws IOException {
		// 建立ServerSocket对象
		ServerSocket ss = new ServerSocket(10001);

		// 阻塞获取Socket对象
		Socket s = ss.accept();

		// 获取数据
		InputStream is = s.getInputStream();
		byte[] buff = new byte[1024];
		String data = new String(buff, 0, is.read(buff));// 阻塞式，read数据时是阻塞式的

		System.out.println("server: " + data);

		// 返回数据给客户端
		OutputStream os = s.getOutputStream();
		os.write("我已经收到了，兄弟".getBytes());

		s.close();
		ss.close();
	}

}
