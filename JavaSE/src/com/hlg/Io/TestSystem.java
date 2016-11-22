package com.hlg.Io;

import java.io.IOException;
import java.util.Scanner;
/*
 * 
 *	标准的输入输出流：
 * 		1)输入流：System.in                  （System类里面有InputStream类的静态字段in）
 * 		2)输出流: System.out					(System类里面有PrintStream类的静态字段out)
 * 
 * 		当我们在屏幕中输入数据后，是直接放在缓冲区中，记录你每一次的输入！！
 *		而System.in.read();的工作就是依次从这个缓冲区中读取下一个字符的ascii码！
 *		比如现在我们在终端输入23，这样我们输出一下read()的值为50，而后我们再read()一次会是51，
 *		再read()一次就是13（回车键的ascii码值)了！！
 *
 *		System.in 代表输入流（文件就是后台缓冲区？）
 *
 *      Scanner：一个可以使用正则表达式来解析基本类型和字符串的简单文本扫描器。
 *      可以从字符串（Readable）、输入流、文件等等来直接构建Scanner对象，
 *      有了Scanner了，就可以逐段（根据正则分隔式）来扫描整个文本，并对扫描后的结果做想要的处理。
 *
 */
import org.junit.Test;


public class TestSystem {
		@Test
	public void test() throws IOException{
		while(true){
			System.out.println(System.in.read());
		}
		}
		
		@Test
	public void test1(){
			Scanner a = new Scanner(System.in);
			String str = a.nextLine();
		}
		
		public static void main(String[] args) {
			//
			Scanner sca = new Scanner(System.in); 
			while (true) {
				System.out.print("输入的字符串：");
				String str = sca.nextLine();
				if (!str.equalsIgnoreCase("e") && !str.equalsIgnoreCase("exit")) {
					System.out.println("输出的字符串大写:" + str.toUpperCase());
				} else {
					break;
				}
			}
				
		}
}
