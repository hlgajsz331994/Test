package com.hlg.DesginPattern1;

import java.util.ArrayList;
import java.util.List;
//����ʽ
public class SingletonTest {
	private SingletonTest(){
		
	}
	private static SingletonTest instance = new SingletonTest();
	private static SingletonTest instance1 = new SingletonTest();
	
	/*public static List getIstance(){
		List<SingletonTest> a = new ArrayList<SingletonTest>();
		a.add(instance);
		a.add(instance1);                                   
		return a;                                       //���ض��󼯺�
		
	}*/
	public static SingletonTest getIstance(){
		return instance;								//���ص�������
	}	
	public void a(){
		
	}
}
