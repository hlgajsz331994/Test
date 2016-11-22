package com.hlg.Io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

/*
 * ·����
 * ��ǰ·�����ڵ�ǰ�ļ�Ŀ¼��Test���µ��ļ�               \\��/
 * ����·���������̷����ڵ�����·��
 * 1.File��һ���࣬�����й������������󣬴˶����Ӧ��һ���ļ���.txt .avi .doc .ppt .mp3 . jpg�����ļ�Ŀ¼
 * 2.File�еķ������漰����������ɾ�����������ȣ��ļ��ڲ����ݲ���������   ���ݲ�����IO�����
 * 3.File�ೣ��ΪIO���ľ�����Ĺ��������βΡ�
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
		System.out.println(filed1.getName()); // �ļ���
		System.out.println(filed1.getPath()); // ���·��
		System.out.println(filed1.getAbsolutePath()); // ����·��
		System.out.println(filed1.getAbsoluteFile());
		System.out.println(filed1.getParentFile());
		System.out.println();
		System.out.println(filed3.getName()); // getAbsolutePath������String�����ļ�·���ַ���
		System.out.println(filed3.getPath()); // getAbsoluteFile: ����File���ļ�����
		System.out.println(filed3.getAbsolutePath());
		System.out.println(filed3.getAbsoluteFile());
		System.out.println(filed3.getParentFile());
		System.out.println();
		// renameTo����ʹ�ã�filed1һ�����ڣ�filed2һ�������ڣ�����boolean���� ���ı��ļ���·����
		// ��filed1ָ����ļ��Ƶ�filed2ָ����ļ�Ŀ¼
		System.out.println(filed1.renameTo(filed2));
		System.out.println(filed1);
		System.out.println(filed2);

	}

	@Test
	public void test2() {
		File filed1 = new File("d:/IO/hello.txt");
		File filed2 = new File("hello1");
		File filed3 = new File("d:\\IO\\hello");
		System.out.println(filed1.exists()); // �ļ���Ŀ¼�Ƿ����
		System.out.println(filed1.canRead()); // �Ƿ�ɶ���д
		System.out.println(filed1.canWrite());
		System.out.println(filed1.isFile()); // �Ƿ����ļ����Ƿ����ļ���
		System.out.println(filed1.isDirectory());
		System.out.println(new Date(filed1.lastModified())); // �����ļ������޸�ʱ��
																// ����long��
		System.out.println(filed1.length()); // �����ļ��Ĵ�С��long�� �ַ���
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
		// boolean a = filed1.createNewFile(); 			//��Ŀ¼�����ڣ����쳣 �����ļ�������boolean
		// System.out.println("�����ɹ���"+a);
		// }else{
		// boolean b = filed1.delete();
		// System.out.println("ɾ���ɹ���"+b); 			//��Ŀ¼�����ڣ����쳣 ɾ���ļ���Ŀ¼������boolean
		// }
		// System.out.println("Ŀ¼����"+filed1.mkdir()); 		//��Ŀ¼�����ڣ����쳣
		// ����Ŀ¼������boolean
		// System.out.println("Ŀ¼����"+filed1.mkdirs()); 		//����һ����Ŀ¼
		// String []array = filed4.list();
		// for(String a:array){
		// System.out.println(a); 			//list:������ǰĿ¼�µ������ļ����ļ���
		// }
		File[] array1 = filed4.listFiles();
		for (File a : array1) {
			System.out.println(a); 	// listFiles():����һ������·�������飬��Щ·������ʾ�˳���·������ʾ��Ŀ¼�е��ļ���
		}

	}
}
