package com.hlg.Test;
//  回车\r  回车是把光标移到一行的前面    换行\n       TAB    \t
//  Enter 是回车加换行
//	在控制台输出时， \r   \n 都能达到换行的效果
//  注意在将流写入文件时，换行应根据操作系统的不同来决定。
//	在程序我们应尽量使用System.getProperty("line.separator")来获取当前系统的换行符，而不是写/r/n或/n。

public class Test4 {
	public static void main(String[] args) {
//		System.out.print("a");  
//		System.out.print("\n");  
//		System.out.print("b");  
//		System.out.print("\r");  
//		System.out.print("c");  
		System.getProperty("line.separator"); //换行
		
		
	}
}
