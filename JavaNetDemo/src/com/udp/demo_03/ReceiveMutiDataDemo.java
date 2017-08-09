package com.udp.demo_03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * 从键盘接收数据，并显示
 */
public class ReceiveMutiDataDemo {

	public static void main(String[] args) throws IOException {
		//创建接收端的Socket服务对象，并指定对象
		DatagramSocket ds = new DatagramSocket(10000);
		//一直接收数据
		while(true){
			//创建数据包
			byte[] bys = new byte[1024];
			DatagramPacket dp = new DatagramPacket(bys, bys.length);
			//接收数据
			ds.receive(dp);
			//解析数据
			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(), 0,dp.getLength());
			System.out.println("接收到 "+ip+"端发来数据：  "+data);
			if(null != data && data.equals("886")){
				System.out.println("退出程序！");
				break;
			}
			
		}
		
		//释放资源，如果要持续接收，那么该流不关
		//ds.close();
	}

}
