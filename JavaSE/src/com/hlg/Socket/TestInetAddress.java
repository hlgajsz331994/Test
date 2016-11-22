package com.hlg.Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;
/*
 * 网络通信的第一个要素：IP地址     通过IP地址唯一地定位互联网上的一台主机
 * InetAddress用来代表IP地址，一个InetAddress对象就代表一个IP地址
 */
public class TestInetAddress {
	@Test
	public void test() throws UnknownHostException{
		//获取本地的主机
//		InetAddress ip = InetAddress.getLocalHost();
//		System.out.println(ip);
//		System.out.println(ip.getHostAddress());
//		System.out.println(ip.getHostName());
		//输入域名或者IP，得到IP对象
		InetAddress ip1 = InetAddress.getByName("PC201407031726");
		System.out.println(ip1);
	}
	
	
}
