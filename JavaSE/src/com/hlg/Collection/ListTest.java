package com.hlg.Collection;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ListTest {
	@Test
	public void test1(){
		/*
		 * 增add()、删remove(int index)、改set(int index , E)、查get(int index)、插(int index ,E)、查大小size()
		 * subList（int a ,int b）:返回从a开始到b结束的一个子List  （左闭右开）
		 */
		List list = new LinkedList();
		list.add("123");
		list.add("aa");
		list.add("bb");
		list.add("456");
		System.out.println(list.get(2));
		
	}
}
