package com.hlg.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.server.SocketSecurityException;

import org.junit.Test;

//TCP编程例二：客户端发送信息给服务端，服务端把收到的信息打印到控制台上，并返回“已收到”信息给客户端
//客户端和服务端的Socket不是同一个
//使用accept()堵塞等待客户请求，有客户请求到来则产生一个Socket对象，并继续运行
public class TestTCP2 {
	@Test
	public void Client() throws UnknownHostException, IOException{
		Socket s = new Socket(InetAddress.getLocalHost(),8888);
//		System.out.println(s.getPort());
//		System.out.println(s.getInetAddress());     //返回套接字连接的地址
		OutputStream os = s.getOutputStream();
		os.write("来自于客户端的信息".getBytes());
		s.shutdownOutput();                //显式地告诉服务端发送完毕
		InputStream is = s.getInputStream();
		int len;
		byte a[] = new byte[10];
		while((len=is.read(a))!= -1){
			String str = new String(a,0,len);
			System.out.println(str);
		}
		os.close();
		is.close();
		s.close();
	}
	@Test
	public void Server() throws IOException{
		ServerSocket ss = new ServerSocket(8888);
		Socket s = ss.accept();
//		System.out.println(s.getInetAddress());
		InputStream is = s.getInputStream();
		int len ;
		byte a[]= new byte[30];
		while((len=is.read(a))!=-1){
			String str = new String(a,0,len);
			System.out.println(str);
		}
		System.out.println("已收到来自"+s.getPort()+"的信息");
		OutputStream os = s.getOutputStream();
		os.write("已收到".getBytes());
		is.close();
		os.close();
		s.close();
		ss.close();
		
		
		
	}
}
