package com.hlg.Io;

import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
/*
 * ʹ��FileReader FileWriter����ʵ���ı��ļ��ĸ���
 * ���ڷ��ı��ļ�����ʹ���ֽ�����       ����Ƶ�ļ���ͼƬ��
 * �ı��ļ�Ҳ����ʹ���ֽ�����
 * 
 */
public class TestReaderWriter {
	@Test
	public void test1() throws IOException {
		FileReader stream1 = new FileReader("hello");
		int len;
		char[] a = new char[5];
		while ((len = stream1.read(a)) != -1) {              // ������Ӣ����ĸҲռһ���ַ�
			System.out.println(len);
			for (int i = 0; i < len; i++) {
				System.out.print(a[i]);
			}
		}
	}
}
