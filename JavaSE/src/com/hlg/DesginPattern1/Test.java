package com.hlg.DesginPattern1;

/*
 * java.util.*包，包含集合框架,collection 类、事件模型、日期和时间设施、国际化和数组各种实用工具类
 * （字符串标记生成器、随机数生成器和位数组）。 
	java.awt.*包，包含用于创建用户界面和绘制图形图像的所有类。
	
	1.单例模式(饿汉式)   方法中只返回对象
	(懒汉式) 在方法中创建对象  再返回对象 ，可能存在线程安全问题
 */
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		SingletonTest.getIstance();    		  //调用唯一对象
		SingletonTest1 a = SingletonTest1.getInstance();
		SingletonTest1 b = SingletonTest1.getInstance();
		System.out.println(a);
		System.out.println(a==b);
		
	}										  //return返回多个对象，利用集合，不同类型可以用数组
}

