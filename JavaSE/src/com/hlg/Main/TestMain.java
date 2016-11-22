package com.hlg.Main;

public class TestMain {
	/*
	 * 调用Main方法
	 */
	/**
	 * @param args
	 */                                         
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMain1.main(new String [1000] );
		String a [] =  {"1","2"};
		
		
		
	}

}
class TestMain1{
	public static void main(String[] args) {
		for(int i = 0;i<args.length;i++){
			args[i] = "value_"+i;
			System.out.println(args[i]);
		}
	}
}
