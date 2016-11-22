package com.hlg.Throwable;

import java.util.Date;

import org.junit.Test;

/*
 * �쳣����ϵ�ṹ:
 * JavaThrowable:
 * 		|----Error:����
 * 		|----Exception:�쳣 
 * 				|----����ʱ�쳣:javac,����ʱ���쳣
 * 						1.�ļ����ܲ�����
 * 				|----����ʱ�쳣:java ������class�ļ�ʱ���쳣
 *					 1.����Խ��:ArrayIndexOutOfBoundsException
 * 					 2.�����쳣:ArithmeticException
 * 					 3.����ת���쳣:ClassCastException
 * 					 4.��ָ���쳣:NullPointerException
 * 
 */
//��ִ��һ����������쳣���쳣֮��Ĵ��붼����ִ��
public class TestException {
	// 1.����Խ���쳣
	// 2.���������쳣
	@Test
	public void Test2() {
		int i = 10;
		System.out.println(i / 0);
	}

	// 3.����ת���쳣
	@Test
	public void Test3() {
		Object obj = new Date();
		String str = (String) obj;
	}

	// 4.��ָ���쳣
	@Test
	public void Test4() {
		Date a = new Date();
		a = null;
		System.out.println(a.toString());
	}
}
