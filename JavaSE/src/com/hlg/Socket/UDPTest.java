package com.hlg.Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.junit.Test;
/*
 * DatagramSocket:套接字、负责发送和接收
 * DatagramPacket：对象封装了UDP数据报，在数据报当中包含了发送端IP地址和端口，接收端IP地址和端口
 * 
 */
public class UDPTest {
	@Test
	public void send() throws IOException{
		DatagramSocket ds = new DatagramSocket();
		byte b[] = new String("我是发送的信息").getBytes();
		//一次发送的数据包小于64K
		DatagramPacket dp = new DatagramPacket(b,0,b.length, InetAddress.getLocalHost(), 9090);
		ds.send(dp);
		
	}
	@Test
	public void receive() throws IOException {
		DatagramSocket ds = new DatagramSocket(9090);
		byte c[] = new byte[1024];
		DatagramPacket dp = new DatagramPacket(c, c.length);
		ds.receive(dp);
		System.out.println(new String(dp.getData(),dp.getOffset(),dp.getLength()));
	}
}
