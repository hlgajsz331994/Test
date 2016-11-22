package com.hlg.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;
/*
 * TCP    ������˿����ȴ�������Ϣ���ͻ��ˣ��������֣�������Ϣ
 * Socket:�׽��֣�IP�Ͷ˿ڣ�
 */
//TCP�����һ
public class TestTCP1 {
	//�ͻ���
	@Test
	public void clinet() throws UnknownHostException, IOException{
		//Socket ͨ��������ָ������˵�IP��ַ�Լ��˿ںţ�Ȼ����������ʽ��������
		Socket s = new Socket("PC201407031726",9090);
		OutputStream os = s.getOutputStream();
		os.write("���ǿͻ���".getBytes());
		os.close();
		s.close();
	}
	//�����
	@Test
	public void Server() throws IOException{
		//ͨ��ServerSocket��accept()�����˿ںţ�����Socket���ȴ���Ϣ����
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
