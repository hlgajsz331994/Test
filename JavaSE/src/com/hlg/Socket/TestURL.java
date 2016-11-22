package com.hlg.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

/*
 * URL��ͳһ��Դ��λ����һ��URL�Ķ��󣬶�Ӧ�Ż������ϵ�һ����Դ��
 * ���ǿ���ͨ��URL�Ķ����������Ӧ�ķ�����������Դ��ȡ�������ء���
 * 
 * 
 */
public class TestURL {
	@Test
	public void test1() throws IOException{
		URL url = new URL("http://localhost/aa/HelloWorld.txt");
		System.out.println(url.getProtocol());      //��ȡЭ��
		System.out.println(url.getHost());			//��ȡ������
		System.out.println(url.getPort());			//��ȡ�˿�	
		System.out.println(url.getFile());			//��ȡ�ļ���
		System.out.println(url.getRef());   		//��ȡ��URL���ļ��е����λ��
		System.out.println(url.getQuery());     	//��ȡ��URL�Ĳ�ѯ��
		//��ν�����˵ĵ���Դ��ȡ����
		InputStream is = url.openStream();
		int len;
		byte []b= new byte[20];
		while((len=is.read(b))!=-1){
			String str = new String(b,0,len);
			System.out.print(str);
		}
		//��μ������ݵ����룬�������ݵ����
		URLConnection u = url.openConnection();
		
	}
}
