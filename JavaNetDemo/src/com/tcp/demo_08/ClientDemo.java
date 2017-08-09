package com.tcp.demo_08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
	public static void main(String[] args) throws IOException{
		//创建客户端对象
		Socket s = new Socket("192.168.0.40", 10003);
		//读取图片
		InputStream is = new FileInputStream("index4.jpg"); 
		
		//写数据到通道
		OutputStream os = s.getOutputStream();
		int len = 0;
		while((len = is.read())!=-1){
			os.write(len);
		}
		s.shutdownOutput();
		
		//接收返回数据
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		while((line = br.readLine())!=null){
			System.out.println("Server返回数据： "+line);
		}
		
		//释放资源
		br.close();
		s.close();
		is.close();
		
	}
}
