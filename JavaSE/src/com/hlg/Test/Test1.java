package com.hlg.Test;
//静态代理
public class Test1 {
	public static void main(String[] args) {
		Product1 a = new Product1();
		a.product();
	}
}
class SuperProduct{
	void product(){
		
		System.out.println("生产一号产品");
	}
}
class Product1 extends SuperProduct{
	void product(){
		System.out.println("开始生产");
		super.product();
		System.out.println("结束生产");
	}
} 