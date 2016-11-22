package com.hlg.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;
/*
 * TCP    ：服务端开启等待接受信息，客户端（三次握手）发送信息
 * Socket:套接字（IP和端口）
 */
//TCP编程例一
public class TestTCP1 {
	//客户端
	@Test
	public void clinet() throws UnknownHostException, IOException{
		//Socket 通过构造器指明服务端的IP地址以及端口号，然后以流的形式发送内容
		Socket s = new Socket("PC201407031726",9090);
		OutputStream os = s.getOutputStream();
		os.write("我是客户端".getBytes());
		os.close();
		s.close();
	}
	//服务端
	@Test
	public void Server() throws IOException{
		//通过ServerSocket的accept()监听端口号，产生Socket，等待信息到来
		ServerSocket ss = new ServerSocket(9090);
		Socket s = ss.accept();
		InputStream is = s.getInputStream();
		byte a[] = new byte[20] ;
		int len ;
		while((len = is.read(a))!= -1){
			String str = new String(a,0,len);
			System.out.println(str);
		}
		System.out.println(s.getInetAddress().getHostName());
		is.close();
		s.close();
		ss.close();
	}
}
