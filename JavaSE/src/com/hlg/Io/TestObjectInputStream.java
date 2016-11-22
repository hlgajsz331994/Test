package com.hlg.Io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

/*
 * ��������ObjectInputStream �� ObjectOutputStream   ��������Ķ���
 * �������л�����:
 * 1.Ҫ֧�����л�������Ҫʵ��Serializable�ӿ�
 * 2.���е�����ҲҪʵ��Serializable�ӿ�    ����������û��ʵ�֣�����int��
 * 3.���л��汾��ʶ private static final long serialVersionUID              ���������к����Զ����ɵģ�����Ӳ�̺����ݸı��ˣ����к�Ҳ���ܸı�
 * 	     ��ʾ���л���ʶ����;��
 * 		--��ϣ����Ĳ�ͬ�汾�����л����ݣ���Ĳ�ͬ�汾����Ҫ����ͬ�ı�ʶ��
 * 		--��ϣ����Ĳ�ͬ�汾�����л������ݣ���Ĳ�ͬ�汾����Ҫ�в�ͬ�ı�ʶ��
 * 4.������static���εı���������ʵ�����л�
 */
public class TestObjectInputStream {
	@Test
	public void testObjectInputStream() {
		
		ObjectInputStream stream1 = null;
		try {
			stream1 = new ObjectInputStream(new FileInputStream("hello3"));
			Person a = (Person)stream1.readObject();
			System.out.println(a);
			Person b = (Person)stream1.readObject();
			System.out.println(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			if (stream1!=null) {
				try {
					stream1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	@Test
	public void testObjectOutputStream(){
		Person per1 = new Person("Сһ", 11);
		Person per2 = new Person("С��", 15);
		ObjectOutputStream stream1 = null;
		try {
			stream1 = new ObjectOutputStream(new FileOutputStream("hello3"));
			stream1.writeObject(per1);
			stream1.flush();
			stream1.writeObject(per2);
			stream1.flush();
		}  catch (IOException e) {
			if (stream1 !=null) {
				// TODO Auto-generated catch block
				try {
					stream1.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}
}
class Person implements Serializable{
	private static final long serialVersionUID = 112333333;           //���л��汾��ʶ
	String name ;
	Integer age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	
}
