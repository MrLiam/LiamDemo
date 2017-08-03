package com.ldl.demo.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 字符缓冲流特有功能
 * public void readLine()
 * public void newLian()
 * 通过特有功能复制字符文件
 * 
 * 需掌握
 */
public class BufferedPeculiarFunCopy {
	public static void main(String[] args) {
		BufferedReader br= null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader("streamWrite.java"));
			bw = new BufferedWriter(new FileWriter("copy.java"));
			String line = null;
			while((line = br.readLine()) != null){
				bw.write(line);
				bw.newLine();
				bw.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bw != null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
