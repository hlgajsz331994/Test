package com.hlg.Io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

/*
 * 1.流的分类
 * 	1)根据流向不同分为：输入流、输出流
 * 	2）根据处理数据单位不同分为：字节流、字符流
 * 	3）根据角色的不同分为：节点流、处理流
 * 2.IO体系
 * 抽象基本类     			节点流    					处理流
 * Input			FileInputStream			BufferedInputStream
 * Output			FileOutputStream		BufferedOutputStream
 * Reader			FileReader				BufferedReader
 * Writer			FileWriter				BufferedWriter
 *  字节流、字符流都可以写汉字，传文件。
 *  
 *  报异常：IOException（FileNotFoundException、IOException）
 */

public class TestInputOutputStream {
	static int a;

	public TestInputOutputStream() {
	}

	// 读取一个文件，写到另一个地方
	@Test
	public void testFileInputOutputStream() throws IOException {
		FileInputStream stream1 = new FileInputStream("hello");
		 FileOutputStream stream2 = new FileOutputStream("hello2");
		byte a[] = new byte[5]; // 根据文件大小，调节每次读写的字节        
		int len;				
		while ((len = stream1.read(a)) != -1) {
			for (int i = 0; i < len; i++) {
				stream2.write(a[i]);
			}
		}
		stream1.close();
		stream2.close();
		// Object b[] = fileList.toArray();
		/*
		 * for(Object b:fileList){ System.out.println(b); }
		 */

	}

	// FileOutputStream
	/*
	 * @Test public void Test2() throws FileNotFoundException{ FileOutputStream
	 * a = new FileOutputStream("hello2"); //声明的时候自动创建文件 }
	 */
	@Test
	public void OutputStreamTest2() throws IOException {
		FileOutputStream stream1 = new FileOutputStream("hello");
		byte[] a = new String("GG").getBytes();
		stream1.write(a);
		byte[] b = new String("JJ").getBytes(); // 同一个流写文件不会覆盖，（不同流会覆盖）？
		stream1.write(b);
		FileOutputStream stream2 = new FileOutputStream("hello"); // 清空原文件
		stream1.write(b); // 从之前的位置开始写
		byte[] c = new String("GGGGG").getBytes();
		stream2.write(c); // 结果：GGGGGJ
		stream1.close();
		stream2.close();

	}

	@Test
	public void OutputStreamTest1() throws IOException {
		FileOutputStream stream1 = new FileOutputStream("hello"); // 输出的文件可以不存在，运行的过程中会自动创建
		// byte []a = {73,32,97,109,32,102,114,111,109,32,67,104,105,110,97,33};
		byte[] a = new String("I am from China! 中国，你好！").getBytes(); // 新建字符串返回byte数组
		for (byte b : a) {
			System.out.println(b);
		}
		stream1.write(a); // 不返回值 ，覆盖文件内部的内容
		stream1.close();
	}

	// FileInputStream
	@Test
	public void InputStreamTest3() throws IOException {
		FileInputStream stream1 = new FileInputStream("hello1");
		byte[] a = new byte[10];
		int len;
		int off = 1;
		while ((len = stream1.read(a, off, 5)) != -1) { // read(byte a,off, len)
			// 写到数组，读进来
			// off：从数组第几位开始写 len：每次写几位
			// System.out.println(len);
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
		}
	}

	@Test
	public void InputStreamTest2() throws IOException {
		FileInputStream stream1 = new FileInputStream("hello1");
		byte[] a = new byte[5];
		int b;
		// System.out.println(stream1.read(a)); //read(byte []b)
		// 返回输入的字节数，到头了返回-1
		while ((b = stream1.read(a)) != -1) {
			System.out.println(b);
			for (int i = 0; i < b; i++) { // 十二个字节，返回552 然后跳出循环
				System.out.print((char) a[i]);
			}
			System.out.println();
		}
		stream1.close();
	}

	@Test
	public void InputStreamTest1() {
		FileInputStream stream1 = null;
		try {
			stream1 = new FileInputStream("hello");
			int a = stream1.read();
			while (a != -1) {
				System.out.println( a); // read（）逐个读取，返回int型字节码
				a = stream1.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stream1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
