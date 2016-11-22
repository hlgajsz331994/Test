package com.hlg.Reflex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理
//接口
interface Subject {
	void method();
}

// 被代理类
class RealSubject implements Subject {

	public void method() {
		// TODO Auto-generated method stub
		System.out.println("被代理类");
	}

}

// 代理类
class MyInvocationHandler implements InvocationHandler {
	Object obj;
	//实例化被代理类，返回一个代理类的对象
	public Object blind(Object obj) {
		this.obj = obj;
		//第一个参数，目标的装载器  
        //第二个参数，目标接口，为每个接口生成代理  
        //第三个参数，调用实现了InvocationHandler的对象，当你一调用代理，代理就会调用InvocationHandler的invoke方法 
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object returnVal = method.invoke(obj, args);
		System.out.println(method.getName());
		return returnVal;
	}
}
public class ProxyTest1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyInvocationHandler pro = new MyInvocationHandler();
		Subject sub=(Subject) pro.blind(new RealSubject());
		sub.method(); //转到实现InvocationHandler接口的实现类的invoke()方法中去
	}

}
