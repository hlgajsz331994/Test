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
	 * 获取所有的方法（返回值类型，权限修饰符，注解，方法名，形参列表，异常）
	 * 获取所有的属性（获取属性的字段名，修饰符，数据类型）
	 * 调用指定的方法和属性
	 */
	@Test
	public void test1() throws Exception {
		//Declared 所有的
		//调用clazz对应的运行时类Person的对象
		Class clazz = Person.class;
		Person p = (Person)clazz.newInstance();        //1.Person类要是无参的构造函数   2.构造器要公开 
													   //newInstance()方法默认调用的就是空参的构造器
		//调用有参的构造方法创建对象        Constructor
		Constructor<Person> cons =clazz.getConstructor(String.class,int.class);
		Person p1 = cons.newInstance("奥特曼",123);
		System.out.println(p1);
//		p.age = 13;
		
		//通过反射调用运行时类指定的属性       只能获取到声明为public的属性
		Field f1 = clazz.getField("name");                      
		f1.set(p, "123");            
				//获取属性的字段名，修饰符，数据类型
				System.out.print(f1.getName()+"\t");    //返回String型
				System.out.print(Modifier.toString(f1.getModifiers())+"\t");          //返回int型
				System.out.println(f1.getType());            //返回Class型
		
		//调用私有属性
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p,13);
		System.out.println(p);
		
		//调用方法           能够获取   （返回值类型，权限修饰符，注解，方法名，形参列表，异常）
		Method m1 = clazz.getMethod("setAge",int.class);
		m1.invoke(p,50);
		System.out.println(p);
		
		//调用父类
		Class clazz1= clazz.getSuperclass();
		System.out.println(clazz1.getName());
		
		//调用接口
		Class clazz2[]=clazz.getInterfaces();
		for(Class a:clazz2){
			System.out.println(a.getName());
		}
	}
}
