package com.tcp.demo_08;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) throws IOException {
		//建立服务器连接对象ServerSocket
		ServerSocket ss = new ServerSocket(10003);
		//监听客户端连接
		Socket s = ss.accept();
		
		//获取输入流
		InputStream is= s.getInputStream();
		//获取输出流
		OutputStream os = new FileOutputStream("girl.jpg");
		byte[] buff = new byte[1024];
		int len = 0;
		while((len = is.read(buff))!=-1){
			os.write(buff, 0, len);
		}
		
		//给出反馈
		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		bf.write("文件上传成功！");
		bf.newLine();
		bf.flush();
		
		//释放资源
		os.close();
		is.close();
		s.close();
		ss.close();
		
	}

}
