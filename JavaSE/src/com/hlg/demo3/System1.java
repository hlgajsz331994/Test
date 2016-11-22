package com.hlg.demo3;

import java.util.Map;
import java.util.Map.Entry;

public class System1 {

	/**
	 * @param args
	 */
	/*
	 * 环境变量使用范例
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> a =System.getenv();
		
		for(Entry<String, String> entry:a.entrySet()){
			System.out.print("KEY:"+entry.getKey()+"\t");        
			System.out.println("VALUE:"+entry.getValue());
		}
	}

}
