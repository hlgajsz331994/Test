package com.hlg.Reflex;
//��̬����ģʽ
//ȱ�㣺ÿһ���µĽӿڶ���Ҫһ���µĴ�����
public class ProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A pro = new  ProxyProduct(new Product());
		pro.product();
		
	}

}
//�ӿ�
interface A{
	void product();
}
//��������
class Product implements A{
	
	public void product() {
		// TODO Auto-generated method stub
		System.out.println("����һ�Ų�Ʒ");
	}
}
//������
class ProxyProduct implements A{
	private A product;
	public ProxyProduct(A product){
		this.product = product;
	}
	public void product() {
		// TODO Auto-generated method stub
		System.out.println("start >>"+"product()");
		product.product();
		System.out.println("success >>"+"product()");
	}
	
}