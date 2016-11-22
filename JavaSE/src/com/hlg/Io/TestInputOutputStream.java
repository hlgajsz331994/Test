package com.hlg.Io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

/*
 * 1.���ķ���
 * 	1)��������ͬ��Ϊ���������������
 * 	2�����ݴ������ݵ�λ��ͬ��Ϊ���ֽ������ַ���
 * 	3�����ݽ�ɫ�Ĳ�ͬ��Ϊ���ڵ�����������
 * 2.IO��ϵ
 * ���������     			�ڵ���    					������
 * Input			FileInputStream			BufferedInputStream
 * Output			FileOutputStream		BufferedOutputStream
 * Reader			FileReader				BufferedReader
 * Writer			FileWriter				BufferedWriter
 *  �ֽ������ַ���������д���֣����ļ���
 *  
 *  ���쳣��IOException��FileNotFoundException��IOException��
 */

public class TestInputOutputStream {
	static int a;

	public TestInputOutputStream() {
	}

	// ��ȡһ���ļ���д����һ���ط�
	@Test
	public void testFileInputOutputStream() throws IOException {
		FileInputStream stream1 = new FileInputStream("hello");
		 FileOutputStream stream2 = new FileOutputStream("hello2");
		byte a[] = new byte[5]; // �����ļ���С������ÿ�ζ�д���ֽ�        
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
	 * a = new FileOutputStream("hello2"); //������ʱ���Զ������ļ� }
	 */
	@Test
	public void OutputStreamTest2() throws IOException {
		FileOutputStream stream1 = new FileOutputStream("hello");
		byte[] a = new String("GG").getBytes();
		stream1.write(a);
		byte[] b = new String("JJ").getBytes(); // ͬһ����д�ļ����Ḳ�ǣ�����ͬ���Ḳ�ǣ���
		stream1.write(b);
		FileOutputStream stream2 = new FileOutputStream("hello"); // ���ԭ�ļ�
		stream1.write(b); // ��֮ǰ��λ�ÿ�ʼд
		byte[] c = new String("GGGGG").getBytes();
		stream2.write(c); // �����GGGGGJ
		stream1.close();
		stream2.close();

	}

	@Test
	public void OutputStreamTest1() throws IOException {
		FileOutputStream stream1 = new FileOutputStream("hello"); // ������ļ����Բ����ڣ����еĹ����л��Զ�����
		// byte []a = {73,32,97,109,32,102,114,111,109,32,67,104,105,110,97,33};
		byte[] a = new String("I am from China! �й�����ã�").getBytes(); // �½��ַ�������byte����
		for (byte b : a) {
			System.out.println(b);
		}
		stream1.write(a); // ������ֵ �������ļ��ڲ�������
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
			// д�����飬������
			// off��������ڼ�λ��ʼд len��ÿ��д��λ
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
		// ����������ֽ�������ͷ�˷���-1
		while ((b = stream1.read(a)) != -1) {
			System.out.println(b);
			for (int i = 0; i < b; i++) { // ʮ�����ֽڣ�����552 Ȼ������ѭ��
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
				System.out.println( a); // read���������ȡ������int���ֽ���
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
