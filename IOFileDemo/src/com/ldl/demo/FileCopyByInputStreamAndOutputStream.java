package com.ldl.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 用字节流复制文件
 * @author ldl
 *
 */
public class FileCopyByInputStreamAndOutputStream {
	public static void main(String[] args) {
		//封装数据源
		FileInputStream fis = null;
		//目标文件
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("FileReaderByCharArray.java");
			fos = new FileOutputStream("streamWrite.java");
			byte[] buff = new byte[1024];//这里的大小只能是1024的整数倍，由于计算机内存分配机制
			int len = 0;
			while((len = fis.read(buff))!=-1){
				fos.write(buff, 0, len);
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//释放资源
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
