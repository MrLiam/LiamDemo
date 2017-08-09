package com.tcp.demo_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 接收客户端的数据，并将数据写入到文件中
 */
public class ServerDemo {

	public static void main(String[] args) throws IOException {
		// 创建服务器连接对象
		ServerSocket ss = new ServerSocket(10002);

		// 阻塞式接收数据
		Socket s = ss.accept();

		// 创建字符接收流
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("receiveFromClient.txt")));
		String line = null;

		while ((line = br.readLine()) != null) {//阻塞式
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		//释放资源
		bw.close();
		s.close();
		ss.close();

	}

}
