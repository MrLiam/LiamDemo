package com.ldl.demo;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 通过字符数组读取字符流中的数据
 * 字符流写入数据的时候必须要刷新缓冲区，不然不能写入数据
 * @author ldl
 *
 */
public class FileReaderByCharArray {
	public static void main(String[] args) throws IOException {
		//writeData();
		FileReader read	= new FileReader("read.txt");
		//定义缓冲数组
		char[] buf = new char[1024];
		int len = 0;
		while((len = read.read(buf))!= -1){
			System.out.println(String.valueOf(buf,0,len));
		}
		//释放资源
		read.close();
	}
	
	public static void writeData() throws IOException{
		//创建字符流对象
		FileWriter write = new FileWriter("read.txt");
		write.write("测试数据一");
		write.write("\r\n");
		write.write(65);
		write.write("\r\n");
		write.write(97);
		write.flush();
		write.close();
		
	}
}
