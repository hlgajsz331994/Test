package com.hlg.Reflex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//��̬����
//�ӿ�
interface Subject {
	void method();
}

// ��������
class RealSubject implements Subject {

	public void method() {
		// TODO Auto-generated method stub
		System.out.println("��������");
	}

}

// ������
class MyInvocationHandler implements InvocationHandler {
	Object obj;
	//ʵ�����������࣬����һ��������Ķ���
	public Object blind(Object obj) {
		this.obj = obj;
		//��һ��������Ŀ���װ����  
        //�ڶ���������Ŀ��ӿڣ�Ϊÿ���ӿ����ɴ���  
        //����������������ʵ����InvocationHandler�Ķ��󣬵���һ���ô�������ͻ����InvocationHandler��invoke���� 
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
		sub.method(); //ת��ʵ��InvocationHandler�ӿڵ�ʵ�����invoke()������ȥ
	}

}
