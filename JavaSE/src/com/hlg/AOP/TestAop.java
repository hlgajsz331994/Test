package com.hlg.AOP;
//��̬������AOP ���������棩
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//�ӿ�
interface Human {
	void newbee();

	void lgd();
}
//��������
class SuperMan implements Human {
	public void lgd() {
		System.out.println("���ǳ���");
	}

	public void newbee() {
		System.out.println("���ǰ�͹��");
	}
}

class Gege {
	void method1() {
		System.out.println("-----����һ-------");
	}

	void method2() {
		System.out.println("-----������-------");
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
		method.invoke(obj, args);         //obj�������Obj
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
