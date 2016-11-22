package com.hlg.Io;
/*
 *  1.���ķ���
 * 	1)��������ͬ��Ϊ���������������
 * 	2�����ݴ������ݵ�λ��ͬ��Ϊ���ֽ������ַ���
 * 	3�����ݽ�ɫ�Ĳ�ͬ��Ϊ���ڵ�����������
 * 2.IO��ϵ
 * ���������     			�ڵ���    					����������������һ�֣������ļ�������Ч�ʣ�(read����������)
 * Input			FileInputStream			BufferedInputStream     
 * Output			FileOutputStream		BufferedOutputStream		flush()
 * Reader			FileReader				BufferedReader				readLine():��һ��    newLine():�½�һ��
 * Writer			FileWriter				BufferedWriter				flush()
 *  �ֽ������ַ���������д���֣����ļ���
 *  
 *  ���쳣��IOException��FileNotFoundException��IOException��
 *  readLine():��һ�У������������ݵ��ַ������������κ�����ֹ��������ѵ�����ĩβ���򷵻� null
 *   			readLine()��BufferedReader�ڲ���װ�Ķ�ȡһ�еķ��������ڲ���һ��char���͵����飬
 *  		           Ҳ��ͨ��ѭ������read����һ���ֽ�һ���ֽڵĶ�ȡ������char�����У�ͨ�������ַ�֮һ������Ϊĳ������ֹ��
 *   			���� ('\n')���س� ('\r') ��س���ֱ�Ӹ��Ż��У�������ѭ����������������������.
 *   			���char������Ϊ��������StringBuffer�У�������

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
			stream4.write(str);					//����д�ַ���
			stream4.newLine();                //�����Զ�����
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
		while((len = stream3.read(a))!= -1){		//read�����Ƿ�����ʽ��
			System.out.println(len);
			stream4.write(a, 0, len);
			stream4.flush();                  //ˢ��һ��
		}
		
		stream3.close();
		stream4.close();         //�رջ������Ϳ�����
		
		
	}
}
