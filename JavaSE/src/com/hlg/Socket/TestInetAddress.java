package com.hlg.Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;
/*
 * ����ͨ�ŵĵ�һ��Ҫ�أ�IP��ַ     ͨ��IP��ַΨһ�ض�λ�������ϵ�һ̨����
 * InetAddress��������IP��ַ��һ��InetAddress����ʹ���һ��IP��ַ
 */
public class TestInetAddress {
	@Test
	public void test() throws UnknownHostException{
		//��ȡ���ص�����
//		InetAddress ip = InetAddress.getLocalHost();
//		System.out.println(ip);
//		System.out.println(ip.getHostAddress());
//		System.out.println(ip.getHostName());
		//������������IP���õ�IP����
		InetAddress ip1 = InetAddress.getByName("PC201407031726");
		System.out.println(ip1);
	}
	
	
}
