package com.hlg.Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.junit.Test;
/*
 * DatagramSocket:�׽��֡������ͺͽ���
 * DatagramPacket�������װ��UDP���ݱ��������ݱ����а����˷��Ͷ�IP��ַ�Ͷ˿ڣ����ն�IP��ַ�Ͷ˿�
 * 
 */
public class UDPTest {
	@Test
	public void send() throws IOException{
		DatagramSocket ds = new DatagramSocket();
		byte b[] = new String("���Ƿ��͵���Ϣ").getBytes();
		//һ�η��͵����ݰ�С��64K
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
