package com.hlg.Collection;

import java.util.HashMap;

public class HashMapTest {

	/**
	 * @param <K>
	 * @param <V>
	 * @param args
	 */                                         //HashMap遍历
	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Object,Object> a = new HashMap<Object, Object>();
		a.put(0, "a");
		a.put(1, "b");
		a.put(2, "c");
		a.put(3, "d");
		for(Object b:a.keySet()){
			System.out.println("集合的Key值为："+b+"      集合的Value值为："+a.get(b));
		}
		
	}

}
