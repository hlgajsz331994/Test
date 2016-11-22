package com.hlg.Io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class Test1 {
	//练习：创建流代替Scanner
	//Inputstream  -- reader  -- BufferedReader
	@Test
	public void test() throws IOException{
//		InputStreamReader stream1 = new InputStreamReader(System.in);
//		BufferedReader stream2 = new BufferedReader(stream1);
//		String str = stream2.readLine();
//		System.out.println(str);
	}
	@Test
	public void test1() throws IOException{
		FileInputStream stream1 = new FileInputStream("src/com/hlg/Reflex/hello");
		System.out.println(stream1.read());
		
	}
}
