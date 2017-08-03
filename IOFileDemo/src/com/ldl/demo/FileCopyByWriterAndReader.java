package com.ldl.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 复制文件
 * @author Administrator
 *
 */
public class FileCopyByWriterAndReader {

	public static void main(String[] args) {
		//定义数据源
		FileReader read = null;
		FileWriter write = null;
		try {
			read = new FileReader("read.txt");
			write = new FileWriter("write.txt");
			char[] buff = new char[1024];
			int len = 0;
			while((len = read.read(buff))!= -1){
				write.write(buff, 0, len);
			}
			System.out.println("复制成功！");
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//释放资源
			if(write != null){
				try {
					write.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(read != null){
				try {
					read.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
