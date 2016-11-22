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
 * 对象流：ObjectInputStream 和 ObjectOutputStream   （传输类的对象）
 * 对象序列化机制:
 * 1.要支持序列化，类需要实现Serializable接口
 * 2.类中的属性也要实现Serializable接口    （基本类型没有实现，例：int）
 * 3.序列化版本标识 private static final long serialVersionUID              （？）序列号是自动生成的，传到硬盘后，内容改变了，序列号也可能改变
 * 	     显示序列化标识的用途：
 * 		--》希望类的不同版本对序列化兼容，类的不同版本就需要有相同的标识号
 * 		--》希望类的不同版本对序列化不兼容，类的不同版本就需要有不同的标识号
 * 4.类中用static修饰的变量，不能实现序列化
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
		Person per1 = new Person("小一", 11);
		Person per2 = new Person("小二", 15);
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
	private static final long serialVersionUID = 112333333;           //序列化版本标识
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
