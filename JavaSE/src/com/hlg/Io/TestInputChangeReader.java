package com.hlg.Io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

/*
 * 
 * 
 * ת����������������InputStreamReader��OutputStreamWriter
 * 		
 * 					1)�ı��ļ� - �ֽ��� - �ַ��� -����     ���룺�ֽ�������ַ���                                             str.getBytes()
 * 					2)����-�ַ���-�ֽ���-�ı��ļ�             ���룺�ַ���-�ֽ�����
 */
public class TestInputChangeReader {
	@Test
	public void test()  {
		FileInputStream stream1 = null;
		FileOutputStream stream4 = null;
		try {
			stream1 = new FileInputStream("db");
			stream4 = new FileOutputStream("db2");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str;
		InputStreamReader stream2 = new InputStreamReader(stream1);
		BufferedReader stream3 = new BufferedReader(stream2);
		OutputStreamWriter stream5 = new OutputStreamWriter(stream4);
		BufferedWriter stream6 = new BufferedWriter(stream5);
		try {
			while((str=stream3.readLine())!=null){
				stream6.write(str);
				stream6.newLine();
				stream6.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			
				if(stream3!=null){
				try {
					stream3.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				if (stream6!=null) {
					try {
						stream6.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
		}
	}
}
