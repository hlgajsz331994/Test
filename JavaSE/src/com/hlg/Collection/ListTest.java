package com.hlg.Collection;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ListTest {
	@Test
	public void test1(){
		/*
		 * ��add()��ɾremove(int index)����set(int index , E)����get(int index)����(int index ,E)�����Сsize()
		 * subList��int a ,int b��:���ش�a��ʼ��b������һ����List  ������ҿ���
		 */
		List list = new LinkedList();
		list.add("123");
		list.add("aa");
		list.add("bb");
		list.add("456");
		System.out.println(list.get(2));
		
	}
}
