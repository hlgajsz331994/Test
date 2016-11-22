package com.hlg.Io;
/*
 *  1.流的分类
 * 	1)根据流向不同分为：输入流、输出流
 * 	2）根据处理数据单位不同分为：字节流、字符流
 * 	3）根据角色的不同分为：节点流、处理流
 * 2.IO体系
 * 抽象基本类     			节点流    					缓冲流（处理流的一种，提升文件操作的效率）(read方法不阻塞)
 * Input			FileInputStream			BufferedInputStream     
 * Output			FileOutputStream		BufferedOutputStream		flush()
 * Reader			FileReader				BufferedReader				readLine():读一行    newLine():新建一行
 * Writer			FileWriter				BufferedWriter				flush()
 *  字节流、字符流都可以写汉字，传文件。
 *  
 *  报异常：IOException（FileNotFoundException、IOException）
 *  readLine():读一行，包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 null
 *   			readLine()是BufferedReader内部封装的读取一行的方法，它内部是一个char类型的数组，
 *  		           也是通过循环调用read方法一个字节一个字节的读取并存入char数组中，通过下列字符之一即可认为某行已终止：
 *   			换行 ('\n')、回车 ('\r') 或回车后直接跟着换行，就跳出循环，不将结束符存入数组.
 *   			最后将char数组作为参数存入StringBuffer中，并返回

 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestBuffered {
	@Test
	public void testBufferedReaderWriter() throws IOException{
		FileReader stream1 = new FileReader("db");
		FileWriter stream2 = new FileWriter("db1");
		BufferedReader stream3 = new BufferedReader(stream1);
		BufferedWriter stream4 = new BufferedWriter(stream2);
		String str;
		while((str = stream3.readLine())!=null){
			stream4.write(str);					//可以写字符串
			stream4.newLine();                //不会自动换行
			stream4.flush();
		}
		stream3.close();
		stream4.close();
	}
	@Test
	public void testBufferedInputOutput() throws IOException{
		FileInputStream stream1 = new FileInputStream("hello1");
		FileOutputStream stream2 = new FileOutputStream("hello2");
		BufferedInputStream stream3 = new BufferedInputStream(stream1);
		BufferedOutputStream stream4 = new BufferedOutputStream(stream2);
		byte []a = new byte[5];
		int len;
		while((len = stream3.read(a))!= -1){		//read方法是非阻塞式的
			System.out.println(len);
			stream4.write(a, 0, len);
			stream4.flush();                  //刷新一下
		}
		
		stream3.close();
		stream4.close();         //关闭缓冲流就可以了
		
		
	}
}
