package com.hlg.Io;

import java.io.IOException;
import java.util.Scanner;
/*
 * 
 *	��׼�������������
 * 		1)��������System.in                  ��System��������InputStream��ľ�̬�ֶ�in��
 * 		2)�����: System.out					(System��������PrintStream��ľ�̬�ֶ�out)
 * 
 * 		����������Ļ���������ݺ���ֱ�ӷ��ڻ������У���¼��ÿһ�ε����룡��
 *		��System.in.read();�Ĺ����������δ�����������ж�ȡ��һ���ַ���ascii�룡
 *		���������������ն�����23�������������һ��read()��ֵΪ50������������read()һ�λ���51��
 *		��read()һ�ξ���13���س�����ascii��ֵ)�ˣ���
 *
 *		System.in �������������ļ����Ǻ�̨����������
 *
 *      Scanner��һ������ʹ��������ʽ�������������ͺ��ַ����ļ��ı�ɨ������
 *      ���Դ��ַ�����Readable�������������ļ��ȵ���ֱ�ӹ���Scanner����
 *      ����Scanner�ˣ��Ϳ�����Σ���������ָ�ʽ����ɨ�������ı�������ɨ���Ľ������Ҫ�Ĵ���
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
				System.out.print("������ַ�����");
				String str = sca.nextLine();
				if (!str.equalsIgnoreCase("e") && !str.equalsIgnoreCase("exit")) {
					System.out.println("������ַ�����д:" + str.toUpperCase());
				} else {
					break;
				}
			}
				
		}
}
