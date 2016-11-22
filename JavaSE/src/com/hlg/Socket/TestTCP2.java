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

//TCP����������ͻ��˷�����Ϣ������ˣ�����˰��յ�����Ϣ��ӡ������̨�ϣ������ء����յ�����Ϣ���ͻ���
//�ͻ��˺ͷ���˵�Socket����ͬһ��
//ʹ��accept()�����ȴ��ͻ������пͻ������������һ��Socket���󣬲���������
public class TestTCP2 {
	@Test
	public void Client() throws UnknownHostException, IOException{
		Socket s = new Socket(InetAddress.getLocalHost(),8888);
//		System.out.println(s.getPort());
//		System.out.println(s.getInetAddress());     //�����׽������ӵĵ�ַ
		OutputStream os = s.getOutputStream();
		os.write("�����ڿͻ��˵���Ϣ".getBytes());
		s.shutdownOutput();                //��ʽ�ظ��߷���˷������
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
		System.out.println("���յ�����"+s.getPort()+"����Ϣ");
		OutputStream os = s.getOutputStream();
		os.write("���յ�".getBytes());
		is.close();
		os.close();
		s.close();
		ss.close();
		
		
		
	}
}
