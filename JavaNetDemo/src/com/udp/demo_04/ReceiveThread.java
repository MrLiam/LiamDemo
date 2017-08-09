package com.udp.demo_04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveThread implements Runnable {
	private DatagramSocket ds;
	
	public ReceiveThread(DatagramSocket ds){
		this.ds = ds;
	}
	
	@Override
	public void run() {
		//一直接收数据
		try {
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
