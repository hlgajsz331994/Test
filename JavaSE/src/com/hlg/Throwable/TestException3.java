package com.hlg.Throwable;
/*
 * 自定义一个异常类:
 * 1.自定义的异常类继承现有的异常类。
 * 2.提供一个序列号，提供几个重载的构造器。
 * 
 * 子类重写的父类方法，其抛出的异常类只能是父类方法抛出的异常类的子类或和异常类一样。
*/
public class TestException3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	

}
class MyException extends RuntimeException{
	  static final long serialVersionUID = -703490745766939L;

	public MyException(String a) {
		super(a);
	}
	  
	  
}
