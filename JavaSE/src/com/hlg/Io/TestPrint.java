package com.hlg.Io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;
/*
 * 打印流：PrintStream(字节流)、PrintWriter(字符流).
 * 数据流(用来处理基本数据类型、String、字节数组的数据)：DataInputStream和DataOutputStream
 */
public class TestPrint {
	//数据流   暗码形式？
	@Test 
	public void Datatest() throws IOException{
		DataOutputStream stream1 = new DataOutputStream(new FileOutputStream("hello3"));
//		stream1.write(89);                         //传入的是字节
		stream1.writeUTF("卡萨帝克里夫即可立即离开");
		stream1.writeDouble(29.15);
		System.out.println(stream1.size());
		stream1.close();
//		FileReader stream2 = new FileReader("hello3");
//		int len ;
//		char a[] = new char[10];
//		while((len=stream2.read(a))!=-1){
//			for(int i = 0;i<len;i++){
//				System.out.println(a[i]);
//			}
//		}
//		stream2.close();
		DataInputStream stream2 = new DataInputStream(new FileInputStream("hello3"));
		String str=stream2.readUTF();                //只读文件中的字符串
		System.out.println(str);
		
	}
	//改变System.out输出的位置
	@Test
	public void test2() throws IOException{
//		FileOutputStream stream1 = new FileOutputStream("hello3"); 
//		PrintStream stream2 = new PrintStream(stream1);
		PrintStream stream1 = new PrintStream("hello3");
		if(stream1 != null){
			System.setOut(stream1);
		}
		System.out.print("改变System.out输出的位置");
		stream1.close();
	}
	@Test
	public void test1() throws IOException {
//		File file = new File("hello3");
//		file.createNewFile();
		String a = "asdfasdfasdf";
		PrintStream stream1 = new PrintStream("hello3");
		PrintStream stream2 = stream1.append(a);
//		stream1.print(a);
//		stream1.print(a);
//		stream1.print(a);
		stream2.print("我也是");
	}
}
