package com.hlg.Reflex;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

public class Test1 {
	@Test
	public void test1() throws IOException{
		File f1 = new File("src/com/hlg/Reflex/hello");
		System.out.println(f1.createNewFile());
		
	}
}
