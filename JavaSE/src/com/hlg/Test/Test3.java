package com.hlg.Test;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
//system.in的  接口属性问题
public class Test3 {
	@Test
	public  void test1() throws IOException{
		InputStream is =System.in;
		is.read();
	}
	public static void main(String[] args) {
		IA a =  IB.a;
		a.read();
	}
}
abstract class IA{
	abstract void read();
}
 class IB{
	static IA a;
}