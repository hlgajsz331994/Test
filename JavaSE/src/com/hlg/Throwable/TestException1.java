package com.hlg.Throwable;

import java.util.Date;

import org.junit.Test;

/*
 * ����Exception�쳣��ץ��ģʽ
 * 1.�ף�ִ�д���ʱ��һ�������쳣���ͻ����쳣���ֵĵط�����һ����Ӧ�쳣���͵�
 * ���󣬲����˶����׳���
 * 2.ץ�������Ĵ�����ץס��һ���������쳣����
 * ���ֵĴ���ʽ   ��try{} catch(){}��(throws +�쳣������    ����������)
 * try{
 * }
 * catch(){
 * }finally{ 
 * }
 * ע:1.try�������ı�������������������
 * 	  2.finally�ǿ�ѡ��
 *    3.catch�����д�쳣����
 *    	>getMessage() �����쳣            PrintStackTrace()  ֱ�Ӵ�ӡ�쳣  
 *    	>catch����������ִ�У�����һ��catch���֮��Ĳ���ִ��
 *    4.�쳣�����ˣ��������ճ�ִ�С�
 *    5.����ʱ�쳣���ɲ�����ʾ����
 *    	����ʱ�쳣����������ʾ����
 *    6.finally�Ҳ�����Ӧ���쳣����Ҳ��ִ�У���return���Ҳ�ᱻִ�У���
 *    7.�쳣û�д���֮��Ĳ���ִ�С�
 *    8.try catch ���໥Ƕ��
 *    9.��׽���쳣����ִ��finally��  ?
 *    
 * 
 */
public class TestException1  {
	// 1.����Խ���쳣
	// 2.���������쳣
	@Test
	public void Test2()throws RuntimeException,Exception {     //���׳�������ܳ��ֵ��쳣��
		int i = 10;
		System.out.println(i / 0);
	}

	// 3.����ת���쳣
	@Test
	public void Test3() {
		Object obj = new Date();
		try {
			String str = (String) obj;
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hello");
	}

	// 4.��ָ���쳣
	@Test
	public void Test4() {
	/*	Date a = new Date();
		a = null;
		try {
			System.out.println(a.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hello��");*/
	}
	public static void main(String[] args) throws  Exception {
		Object obj = new Date();
		try {
			String str = (String) obj;
		} catch (ClassCastException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally{
			System.out.println("hello��");
			}
		System.out.println("hello�����");
		TestException1 test = new TestException1();
		test.Test2();                             //�׳��������쳣�ɲ�������
//		System.out.println(FinallyTest.a());
		
	}
	static class FinallyTest{
		
		@SuppressWarnings("finally")
		static int a(){
			 try {
				System.out.println(10/0);
				return 1;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("123");
				System.out.println("123");
				System.out.println("123");
				System.out.println("123");
				System.out.println("123");
				System.out.println("123");
				return 2;
			}finally{
				return 3;
			}
		}
		}
	
}
