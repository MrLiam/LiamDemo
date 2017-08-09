package com.udp.demo_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * 发送从键盘输入的数据
 */
public class SendDateDemo {

	public static void main(String[] args) throws IOException {

		//创建Socket服务对象
		DatagramSocket ds = new DatagramSocket();
		//封装键盘录入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = br.readLine())!=null){
			//创建数据包
			byte[] datas = line.getBytes(); 
			DatagramPacket dp = new DatagramPacket(datas, datas.length, InetAddress.getByName("127.0.0.1"), 10000);
			//发送数据
			ds.send(dp);
			if(line.equals("886")){
				break;
			}
			
		}
		br.close();
		//释放资源
		ds.close();
	}

}
