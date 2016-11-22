package com.hlg.Reflex;
//静态代理模式
//缺点：每一个新的接口都需要一个新的代理类
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
//接口
interface A{
	void product();
}
//被代理类
class Product implements A{
	
	public void product() {
		// TODO Auto-generated method stub
		System.out.println("生产一号产品");
	}
}
//代理类
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