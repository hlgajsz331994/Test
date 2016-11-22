package com.hlg.Reflex;
/*
 * 我们创建一个类，通过javac生成.class文件，之后使用java.exe加载（JVM）.class文件。
 * .class文件加载到内存后，就是一个运行时类，存在缓存区。
 * 这个运行时类本身就是一个Class类的实例
 * 1.每一个运行时类只加载一次！
 * 2.有了Class的实例后，可以进行如下操作：
 * 			1）创建对应类的对象
 * 			2）获取对应的运行时类的完整的结构
 * 				（属性<Filed>、方法<Method>、构造器<Constructor>、内部类、父类<SuperClass>、所在的包、异常、注解。。。）
 * 							
 * 			3）调用对应的运行时类的指定的结构（方法、属性、构造器）
 * 			4）反射的应用：动态代理
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
	
	//加载器
	@Test
	public void test3() throws Exception{
		ClassLoader loader1=ClassLoader.getSystemClassLoader(); //获取系统加载器  SystemClassLoader
		System.out.println(loader1);
		
		Class clazz1 = Person.class;
		ClassLoader loader2= clazz1.getClassLoader();    //获取加载此类的加载器
		System.out.println(loader2);
		
		String strName = "java.lang.Object";
		Class clazz2 = Class.forName(strName);
		ClassLoader loader3 = clazz2.getClassLoader();            //顶层的核心类加载器，无法访问
		System.out.println(loader3);
	}
	//反射的使用
	@Test
	public void test2() throws Exception{
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
//		p.name = "1234";
		System.out.println(p);
		
		//调用私有属性
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p,13);
		System.out.println(p);
		
		//调用方法
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
	@Test
	//如何获取Class的实例（三种方法）
	public void test1() throws ClassNotFoundException{
		//1.调用运行时类本身的.class属性
		Class clazz = Person.class;
		System.out.println(clazz.getName());
		//2.通过类的对象
		Person p = new Person();
		Class clazz1 = p.getClass();
		System.out.println(clazz1.getName());
		//3.通过Class的静态方法获取                                                  类的路径
		String className = "com.hlg.Reflex.Person";
		Class clazz2 = Class.forName(className);
		System.out.println(clazz2.getName());
		//4.通过类的加载器
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class clazz3 = classLoader.loadClass(className); //传入一个二进制名称？  //用此加载器加载一个类，获得.class文件
		System.out.println(clazz3.getName());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
class abc{
	
}
