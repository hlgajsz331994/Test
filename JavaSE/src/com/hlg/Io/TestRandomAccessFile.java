package com.hlg.Io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;
/*
 * RandomAccessFile :随机访问文件
 * 1.既可以当一个输入流，也可以当一个输出流
 * 2.支持从文件的开头读取、写入
 * 3.支持从任意位置的读取、写入（插入）
 * Mode：
		"r" 以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。  
		"rw" 打开以便读取和写入。如果该文件尚不存在，则尝试创建该文件。  
		"rws" 打开以便读取和写入，对于 "rw"，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备。  
		"rwd"   打开以便读取和写入，对于 "rw"，还要求对文件内容的每个更新都同步写入到底层存储设备。 

 */
public class TestRandomAccessFile {
	//实现插入的效果， 有readLIne方法                            （结果出问题了？？？）                    
	@Test
	public void test2() {
		RandomAccessFile stream1 = null;
		try {
			stream1 = new RandomAccessFile("random1", "rw");
			stream1.seek(4);
			int len;
			StringBuffer sb = null;
			byte a[] = new byte[10];
			while((len = stream1.read(a)) != -1){
				sb = new StringBuffer(new String(a,0,len));
				System.out.print(sb.toString());
			}
			stream1.seek(4);
			stream1.write("xy".getBytes());
			stream1.write(sb.toString().getBytes());
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stream1!=null){
				try {
					stream1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	@Test
	public void test1() throws IOException{
		RandomAccessFile stream1 = new RandomAccessFile("random1", "rw");
		RandomAccessFile stream2 = new RandomAccessFile("random2", "rw");
		stream1.seek(2);                   //二号位置开始读
		byte a[] = new byte[5];
		int len;
		while((len = stream1.read(a))!=-1){
			stream2.write(a,0,len);
		}
		
	}
	@Test
	public void test() throws IOException{
		RandomAccessFile stream1 = new RandomAccessFile("random1", "rw");
		RandomAccessFile stream2 = new RandomAccessFile("random1", "rw");
		byte a[] = "一号位置".getBytes();
		stream1.seek(1);            //从0开始，插到第一号开始写入   1234567890
		stream1.write(a);			//结果： 1一号位置0     实现的是覆盖效果
		
		
		
		
	
		
		
	}
}
