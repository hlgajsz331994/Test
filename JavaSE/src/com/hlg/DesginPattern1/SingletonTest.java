package com.hlg.DesginPattern1;

import java.util.ArrayList;
import java.util.List;
//饿汉式
public class SingletonTest {
	private SingletonTest(){
		
	}
	private static SingletonTest instance = new SingletonTest();
	private static SingletonTest instance1 = new SingletonTest();
	
	/*public static List getIstance(){
		List<SingletonTest> a = new ArrayList<SingletonTest>();
		a.add(instance);
		a.add(instance1);                                   
		return a;                                       //返回对象集合
		
	}*/
	public static SingletonTest getIstance(){
		return instance;								//返回单个对象
	}	
	public void a(){
		
	}
}
