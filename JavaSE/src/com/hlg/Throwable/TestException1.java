package com.hlg.Throwable;

import java.util.Date;

import org.junit.Test;

/*
 * 处理Exception异常：抓抛模式
 * 1.抛：执行代码时，一旦出现异常，就会在异常出现的地方产生一个对应异常类型的
 * 对象，并将此对象抛出。
 * 2.抓（真正的处理）：抓住上一步产生的异常对象：
 * 显现的处理方式   （try{} catch(){}）(throws +异常的类型    方法声明处)
 * try{
 * }
 * catch(){
 * }finally{ 
 * }
 * 注:1.try中声明的变量，不能在外面引用
 * 	  2.finally是可选的
 *    3.catch语句中写异常处理
 *    	>getMessage() 返回异常            PrintStackTrace()  直接打印异常  
 *    	>catch语句从上往下执行，进入一个catch语句之后的不再执行
 *    4.异常处理了，其后代码照常执行。
 *    5.运行时异常，可不做显示处理。
 *    	编译时异常，必须做显示处理。
 *    6.finally找不到对应的异常处理，也会执行（有return语句也会被执行）。
 *    7.异常没有处理，之后的不会执行。
 *    8.try catch 可相互嵌套
 *    9.捕捉到异常后，先执行finally。  ?
 *    
 * 
 */
public class TestException1  {
	// 1.数组越界异常
	// 2.算术运行异常
	@Test
	public void Test2()throws RuntimeException,Exception {     //可抛出多个可能出现的异常类
		int i = 10;
		System.out.println(i / 0);
	}

	// 3.类型转换异常
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

	// 4.空指针异常
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
		System.out.println("hello！");*/
	}
	public static void main(String[] args) throws  Exception {
		Object obj = new Date();
		try {
			String str = (String) obj;
		} catch (ClassCastException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally{
			System.out.println("hello！");
			}
		System.out.println("hello！你好");
		TestException1 test = new TestException1();
		test.Test2();                             //抛出的运行异常可不做处理
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
