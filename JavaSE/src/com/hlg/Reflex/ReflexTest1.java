package com.hlg.Reflex;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class ReflexTest1 {
	
	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws Exception 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 */
	/*
	 * ��ȡ���еķ���������ֵ���ͣ�Ȩ�����η���ע�⣬���������β��б��쳣��
	 * ��ȡ���е����ԣ���ȡ���Ե��ֶ��������η����������ͣ�
	 * ����ָ���ķ���������
	 */
	@Test
	public void test1() throws Exception {
		//Declared ���е�
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
				//��ȡ���Ե��ֶ��������η�����������
				System.out.print(f1.getName()+"\t");    //����String��
				System.out.print(Modifier.toString(f1.getModifiers())+"\t");          //����int��
				System.out.println(f1.getType());            //����Class��
		
		//����˽������
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p,13);
		System.out.println(p);
		
		//���÷���           �ܹ���ȡ   ������ֵ���ͣ�Ȩ�����η���ע�⣬���������β��б��쳣��
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
}
