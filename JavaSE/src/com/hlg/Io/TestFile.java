package com.hlg.Io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

/*
 * 路径：
 * 当前路径：在当前文件目录（Test）下的文件               \\或/
 * 绝对路径：包括盘符在内的完整路径
 * 1.File是一个类，可以有构造器创建对象，此对象对应着一个文件（.txt .avi .doc .ppt .mp3 . jpg）或文件目录
 * 2.File中的方法仅涉及到：创建、删除、重命名等，文件内部内容操作不到。   内容操作由IO流完成
 * 3.File类常作为IO流的具体类的构造器的形参。
 * 4.
 * 	 	
 * 
 */
public class TestFile {
	@Test
	public void test1() {
		File filed1 = new File("d:/IO/hello.txt");
		File filed2 = new File("hello1");
		File filed3 = new File("d:\\IO\\hello");
		System.out.println(filed1);
		System.out.println(filed1.getName()); // 文件名
		System.out.println(filed1.getPath()); // 相对路径
		System.out.println(filed1.getAbsolutePath()); // 绝对路径
		System.out.println(filed1.getAbsoluteFile());
		System.out.println(filed1.getParentFile());
		System.out.println();
		System.out.println(filed3.getName()); // getAbsolutePath：返回String类型文件路径字符串
		System.out.println(filed3.getPath()); // getAbsoluteFile: 返回File型文件对象
		System.out.println(filed3.getAbsolutePath());
		System.out.println(filed3.getAbsoluteFile());
		System.out.println(filed3.getParentFile());
		System.out.println();
		// renameTo方法使用：filed1一定存在，filed2一定不存在，返回boolean类型 （改变文件的路径）
		// 把filed1指向的文件移到filed2指向的文件目录
		System.out.println(filed1.renameTo(filed2));
		System.out.println(filed1);
		System.out.println(filed2);

	}

	@Test
	public void test2() {
		File filed1 = new File("d:/IO/hello.txt");
		File filed2 = new File("hello1");
		File filed3 = new File("d:\\IO\\hello");
		System.out.println(filed1.exists()); // 文件或目录是否存在
		System.out.println(filed1.canRead()); // 是否可读和写
		System.out.println(filed1.canWrite());
		System.out.println(filed1.isFile()); // 是否是文件，是否是文件夹
		System.out.println(filed1.isDirectory());
		System.out.println(new Date(filed1.lastModified())); // 返回文件最后的修改时间
																// 返回long型
		System.out.println(filed1.length()); // 返回文件的大小，long型 字符数
	}

	@Test
	public void test3() throws IOException {
		File filed1 = new File("d:/io/io1/hello");
		File filed2 = new File("hello1");
		File filed3 = new File("d:\\IO\\hello");
		File filed4 = new File("d:");

		// System.out.println();
		//		
		// if(!filed1.exists()){
		// boolean a = filed1.createNewFile(); 			//父目录不存在，抛异常 创建文件，返回boolean
		// System.out.println("创建成功："+a);
		// }else{
		// boolean b = filed1.delete();
		// System.out.println("删除成功："+b); 			//父目录不存在，抛异常 删除文件或目录，返回boolean
		// }
		// System.out.println("目录创建"+filed1.mkdir()); 		//父目录不存在，抛异常
		// 创建目录，返回boolean
		// System.out.println("目录创建"+filed1.mkdirs()); 		//创建一整个目录
		// String []array = filed4.list();
		// for(String a:array){
		// System.out.println(a); 			//list:给出当前目录下的所有文件或文件夹
		// }
		File[] array1 = filed4.listFiles();
		for (File a : array1) {
			System.out.println(a); 	// listFiles():返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
		}

	}
}
