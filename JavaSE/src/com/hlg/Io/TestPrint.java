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
 * ��ӡ����PrintStream(�ֽ���)��PrintWriter(�ַ���).
 * ������(������������������͡�String���ֽ����������)��DataInputStream��DataOutputStream
 */
public class TestPrint {
	//������   ������ʽ��
	@Test 
	public void Datatest() throws IOException{
		DataOutputStream stream1 = new DataOutputStream(new FileOutputStream("hello3"));
//		stream1.write(89);                         //��������ֽ�
		stream1.writeUTF("�����ۿ���򼴿������뿪");
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
		String str=stream2.readUTF();                //ֻ���ļ��е��ַ���
		System.out.println(str);
		
	}
	//�ı�System.out�����λ��
	@Test
	public void test2() throws IOException{
//		FileOutputStream stream1 = new FileOutputStream("hello3"); 
//		PrintStream stream2 = new PrintStream(stream1);
		PrintStream stream1 = new PrintStream("hello3");
		if(stream1 != null){
			System.setOut(stream1);
		}
		System.out.print("�ı�System.out�����λ��");
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
		stream2.print("��Ҳ��");
	}
}
