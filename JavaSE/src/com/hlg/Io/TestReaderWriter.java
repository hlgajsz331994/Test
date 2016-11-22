package com.hlg.Io;

import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
/*
 * 使用FileReader FileWriter可以实现文本文件的复制
 * 对于非文本文件必须使用字节流。       （视频文件，图片）
 * 文本文件也可以使用字节流。
 * 
 */
public class TestReaderWriter {
	@Test
	public void test1() throws IOException {
		FileReader stream1 = new FileReader("hello");
		int len;
		char[] a = new char[5];
		while ((len = stream1.read(a)) != -1) {              // 在这里英文字母也占一个字符
			System.out.println(len);
			for (int i = 0; i < len; i++) {
				System.out.print(a[i]);
			}
		}
	}
}
