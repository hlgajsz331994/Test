package com.hlg.DesginPattern1;

/*
 * java.util.*�����������Ͽ��,collection �ࡢ�¼�ģ�͡����ں�ʱ����ʩ�����ʻ����������ʵ�ù�����
 * ���ַ���������������������������λ���飩�� 
	java.awt.*�����������ڴ����û�����ͻ���ͼ��ͼ��������ࡣ
	
	1.����ģʽ(����ʽ)   ������ֻ���ض���
	(����ʽ) �ڷ����д�������  �ٷ��ض��� �����ܴ����̰߳�ȫ����
 */
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		SingletonTest.getIstance();    		  //����Ψһ����
		SingletonTest1 a = SingletonTest1.getInstance();
		SingletonTest1 b = SingletonTest1.getInstance();
		System.out.println(a);
		System.out.println(a==b);
		
	}										  //return���ض���������ü��ϣ���ͬ���Ϳ���������
}

