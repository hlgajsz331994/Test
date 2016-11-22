package com.hlg.Annotation;
/*
 *     @override   声明重写
 *     @Deprecated 		声明方法已过时
 *     @SuppressWarnings		抑制编译器警告
 *     
 */
public class TestAnnocation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		int a ;
	}

}
//自定义注解
@interface my{
	String [] value();
}

