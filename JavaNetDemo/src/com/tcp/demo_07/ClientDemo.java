package com.tcp.demo_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
 * 从键盘录入数据，并将数据发送到服务器
 */
public class ClientDemo {

	public static void main(String[] args) throws IOException {

		// 建立客户端连接Socket对象
		Socket s = new Socket("192.168.0.40",10002);

		// 创建键盘输入字符流对象
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 创建接收流对象
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		String line = null;
		// 写数据到管道
		while ((line = br.readLine()) != null) {
			if ("886".equals(line)) {
				break;
			}
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		//s.shutdownOutput();关闭输入流   如果不加这句，服务器不能返回数据
		
		//释放资源
		s.close();

	}

}
