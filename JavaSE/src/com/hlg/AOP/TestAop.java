package com.hlg.AOP;
//动态代理与AOP （面向切面）
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//接口
interface Human {
	void newbee();

	void lgd();
}
//被代理类
class SuperMan implements Human {
	public void lgd() {
		System.out.println("我是超人");
	}

	public void newbee() {
		System.out.println("我是凹凸曼");
	}
}

class Gege {
	void method1() {
		System.out.println("-----方法一-------");
	}

	void method2() {
		System.out.println("-----方法二-------");
	}
}

class MyProxy implements InvocationHandler {
	private Object obj;

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		Gege gege = new Gege();
		gege.method1();
		method.invoke(obj, args);         //obj是上面的Obj
		gege.method2();
		return null;
	}
}

class Handle {
	static Object handle(Object obj) {
		MyProxy pro = new MyProxy();
		pro.setObj(obj);

		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), pro);

	}
}

public class TestAop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperMan man = new SuperMan();
		Object obj = Handle.handle(man);
		Human human = (Human) obj;
		human.lgd();
		System.out.println();
		human.newbee();
		
	}

}
