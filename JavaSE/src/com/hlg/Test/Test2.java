package com.hlg.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Test;

//×èÈû
public class Test2 {
	@Test
	public void test() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int len;
		char a[] = new char[20];
		System.out.println("a");
		bf.read();
//		while ((len = bf.read(a)) != -1) {
//			System.out.println(len);
//			String str = new String(a, 0, len);
//			System.out.println(str);
//		}
		
//		String str;
//		while((str=bf.readLine())!=null){
//			System.out.println(str);
//		}
		
//		Reader rea = new InputStreamReader(System.in);
//		char a[] = new char[20];
//		int len;
//		System.out.println("a");
//		rea.read();
//		while((len=rea.read(a))!=-1){
//			String str = new String(a,0,len);
//			System.out.println(str);
//		}

	}
}
