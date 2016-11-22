package com.hlg.Throwable;

import java.util.Date;

import org.junit.Test;

/*
 * 异常的体系结构:
 * JavaThrowable:
 * 		|----Error:错误
 * 		|----Exception:异常 
 * 				|----编译时异常:javac,编译时的异常
 * 						1.文件可能不存在
 * 				|----运行时异常:java ，运行class文件时的异常
 *					 1.数组越界:ArrayIndexOutOfBoundsException
 * 					 2.算术异常:ArithmeticException
 * 					 3.类型转换异常:ClassCastException
 * 					 4.空指针异常:NullPointerException
 * 
 */
//当执行一个程序出现异常，异常之后的代码都不再执行
public class TestException {
	// 1.数组越界异常
	// 2.算术运行异常
	@Test
	public void Test2() {
		int i = 10;
		System.out.println(i / 0);
	}

	// 3.类型转换异常
	@Test
	public void Test3() {
		Object obj = new Date();
		String str = (String) obj;
	}

	// 4.空指针异常
	@Test
	public void Test4() {
		Date a = new Date();
		a = null;
		System.out.println(a.toString());
	}
}
