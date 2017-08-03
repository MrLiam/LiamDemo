package com.ldl.demo.buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 缓冲字节流复制文件
 * 
 */
public class BufferedInputStreamAndOutputStreamCopy {
	public static void main(String[] args) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream("index.jpg"));
			bos = new BufferedOutputStream(new FileOutputStream("peri.jpg"));
			//方式一
			int len = 0;
//			while((len = bis.read())!= -1){
//				bos.write(len);
//			}
			byte[] buff = new byte[1024];
			while((len = bis.read(buff))!= -1){
				bos.write(buff, 0, len);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bos!= null){
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bis!=null){
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
