package com.ldl.demo.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/*
 * 高效流
 * IO:
 * 基本流(基本流)：FileReader,FileWriter,FileInputStream,FileOutputStream
 * 高级流(处理流):针对基本的流进行进一步操作；
 * BufferedWriter构造方法：
 *    BufferedWriter(Writer out)
 * 为什么参数传递是一个Writer呢？
 * 		因为BufferedXxx仅仅是提供高效的操作，真正的读写还需要基本流来完成。
 */
public class BufferedWriterDemo {
	public static void main(String[] args) throws IOException {
		Writer writer = new FileWriter("bufferWriter.txt");
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write("我爱你\r\n");
		bw.write("Java\r\n");
		bw.write("哈哈！");
		bw.close();//这里bw的关闭相当于writer的关闭
	}
}
