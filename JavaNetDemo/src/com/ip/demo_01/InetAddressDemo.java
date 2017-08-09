package com.ip.demo_01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) {
		//获取Ip地址
		try {
			InetAddress ia = InetAddress.getByName("PC-201407181200");
			System.out.println(ia.getHostAddress()+" -- "+ia.getHostName()+"  --  "+ia.getAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
