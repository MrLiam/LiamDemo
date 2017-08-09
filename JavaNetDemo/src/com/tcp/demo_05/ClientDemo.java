package com.tcp.demo_05;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/*
 * TCP协议发送数据的步骤：
 * A：创建发送数据的Socket对象 。//如果这步没问题，已经建立连接了
 * 		创建对象的时候要指定目标主机和端口。
 * B：获取Socket对象的输出流。
 * 		是字节流还是字符流？字节流
 * C: 写数据。
 * D: 释放资源。
 */
public class ClientDemo {

	public static void main(String[] args) throws IOException{

		//创建发送数据的Socket对象
		Socket s = new Socket("192.168.0.40",10001);
		//直接运行
		//Exception in thread "main" java.net.ConnectException: Connection refused: connect
		//因为服务器没有开启。TCP协议的程序，必须先开启服务器。
		
		
		//获取Socket对象的输出流
		OutputStream os = s.getOutputStream();
		
		//写数据
		os.write("测试TCp协议".getBytes());
		
		//释放资源
		os.close();
	}

}
