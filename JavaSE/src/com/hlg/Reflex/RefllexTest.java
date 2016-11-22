package com.hlg.Reflex;
/*
 * ���Ǵ���һ���࣬ͨ��javac����.class�ļ���֮��ʹ��java.exe���أ�JVM��.class�ļ���
 * .class�ļ����ص��ڴ�󣬾���һ������ʱ�࣬���ڻ�������
 * �������ʱ�౾�����һ��Class���ʵ��
 * 1.ÿһ������ʱ��ֻ����һ�Σ�
 * 2.����Class��ʵ���󣬿��Խ������²�����
 * 			1��������Ӧ��Ķ���
 * 			2����ȡ��Ӧ������ʱ��������Ľṹ
 * 				������<Filed>������<Method>��������<Constructor>���ڲ��ࡢ����<SuperClass>�����ڵİ����쳣��ע�⡣������
 * 							
 * 			3�����ö�Ӧ������ʱ���ָ���Ľṹ�����������ԡ���������
 * 			4�������Ӧ�ã���̬����
 */
import java.io.FileDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class RefllexTest {
	
	
	/**
	 * @param args
	 * @throws Exception 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	//������
	@Test
	public void test3() throws Exception{
		ClassLoader loader1=ClassLoader.getSystemClassLoader(); //��ȡϵͳ������  SystemClassLoader
		System.out.println(loader1);
		
		Class clazz1 = Person.class;
		ClassLoader loader2= clazz1.getClassLoader();    //��ȡ���ش���ļ�����
		System.out.println(loader2);
		
		String strName = "java.lang.Object";
		Class clazz2 = Class.forName(strName);
		ClassLoader loader3 = clazz2.getClassLoader();            //����ĺ�������������޷�����
		System.out.println(loader3);
	}
	//�����ʹ��
	@Test
	public void test2() throws Exception{
		//����clazz��Ӧ������ʱ��Person�Ķ���
		Class clazz = Person.class;
		Person p = (Person)clazz.newInstance();        //1.Person��Ҫ���޲εĹ��캯��   2.������Ҫ���� 
													   //newInstance()����Ĭ�ϵ��õľ��ǿղεĹ�����
		//�����вεĹ��췽����������        Constructor
		Constructor<Person> cons =clazz.getConstructor(String.class,int.class);
		Person p1 = cons.newInstance("������",123);
		System.out.println(p1);
//		p.age = 13;
		
		//ͨ�������������ʱ��ָ��������       ֻ�ܻ�ȡ������Ϊpublic������
		Field f1 = clazz.getField("name");                      
		f1.set(p, "123");            
//		p.name = "1234";
		System.out.println(p);
		
		//����˽������
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p,13);
		System.out.println(p);
		
		//���÷���
		Method m1 = clazz.getMethod("setAge",int.class);
		m1.invoke(p,50);
		System.out.println(p);
		
		//���ø���
		Class clazz1= clazz.getSuperclass();
		System.out.println(clazz1.getName());
		
		//���ýӿ�
		Class clazz2[]=clazz.getInterfaces();
		for(Class a:clazz2){
			System.out.println(a.getName());
		}
	}
	@Test
	//��λ�ȡClass��ʵ�������ַ�����
	public void test1() throws ClassNotFoundException{
		//1.��������ʱ�౾���.class����
		Class clazz = Person.class;
		System.out.println(clazz.getName());
		//2.ͨ����Ķ���
		Person p = new Person();
		Class clazz1 = p.getClass();
		System.out.println(clazz1.getName());
		//3.ͨ��Class�ľ�̬������ȡ                                                  ���·��
		String className = "com.hlg.Reflex.Person";
		Class clazz2 = Class.forName(className);
		System.out.println(clazz2.getName());
		//4.ͨ����ļ�����
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class clazz3 = classLoader.loadClass(className); //����һ�����������ƣ�  //�ô˼���������һ���࣬���.class�ļ�
		System.out.println(clazz3.getName());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
class abc{
	
}
