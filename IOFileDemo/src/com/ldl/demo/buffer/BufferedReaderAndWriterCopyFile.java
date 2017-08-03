package com.ldl.demo.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 通过缓冲高效流复制文件
 */
public class BufferedReaderAndWriterCopyFile {
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader("bufferedReader.txt"));
			bw = new BufferedWriter(new FileWriter("bufferedWriter.txt"));
			int len = 0;
			//方式一
//			while((len = br.read())!= -1){
//				bw.write(len);
//			}
			//方式二
			char[] buff = new char[1024];
			while((len = br.read(buff))!= -1){
				bw.write(buff, 0, len);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw != null){
					bw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(br!=null){
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
