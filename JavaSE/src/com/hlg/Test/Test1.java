package com.hlg.Test;
//��̬����
public class Test1 {
	public static void main(String[] args) {
		Product1 a = new Product1();
		a.product();
	}
}
class SuperProduct{
	void product(){
		
		System.out.println("����һ�Ų�Ʒ");
	}
}
class Product1 extends SuperProduct{
	void product(){
		System.out.println("��ʼ����");
		super.product();
		System.out.println("��������");
	}
} 