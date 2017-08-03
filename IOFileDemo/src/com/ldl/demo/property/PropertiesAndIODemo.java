package com.ldl.demo.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Set;

/*
 * 通过Properties类直接与文件相关联
 * 读写文件操作，Properties是Hashtable子类
 */
public class PropertiesAndIODemo {
	public static void main(String[] args) throws IOException {
		//write();
		read();
	}
	
	public static void write() throws IOException{
		Properties pop = new Properties();
		pop.setProperty("name", "ldl");
		pop.setProperty("sex", "男");
		pop.setProperty("年龄", "25");
		pop.store(new FileOutputStream("2017.properties"), "备注");
	}
	
	public static void read() throws IOException{
		Properties pop = new Properties();
		pop.load(new FileInputStream("2017.properties"));
		Set<String> keys = pop.stringPropertyNames();
		for (String string : keys) {
			System.out.println("属性值是： "+string+"="+pop.getProperty(string));
		}
	}
}
