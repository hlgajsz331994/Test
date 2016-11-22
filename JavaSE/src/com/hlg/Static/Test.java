package com.hlg.Static;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestAccount a = new TestAccount(123456, 1000);
		TestAccount b = new TestAccount(123456, 2000);
		TestAccount c = new TestAccount(123456, 3000);
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(Instance.instance());
	}                                                       //静态代码块先于静态方法生成
}
class Instance{
	static int a;
	static{a=11;}
	static int instance(){
		a=a+1;
		return a ;
	}
	
}