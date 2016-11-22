package com.hlg.Socket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

//�ͻ��˷����ļ�������ˣ�����˽��ļ����浽���أ�������"���ͳɹ�"���ͻ��ˡ��ر���Ӧ�����ӡ�

public class TestTCP3 {

	@Test
	public void Client() throws UnknownHostException, IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Administrator\\Desktop\\Ascall��.jpg");
		Socket s = new Socket(InetAddress.getLocalHost(), 8898);
		OutputStream os = s.getOutputStream();
		int len;
		byte a[] = new byte[10];
		while ((len = fis.read(a)) != -1) {
			os.write(a, 0, len);
		}
		s.shutdownOutput();
		InputStream is = s.getInputStream();

		while ((len = is.read(a)) != -1) {
			String str = new String(a, 0, len);
			System.out.println(str);

		}
		is.close();
		os.close();
		s.close();
		fis.close();

	}

	@Test
	public void Server() throws IOException {
		ServerSocket ss = new ServerSocket(8898);
		Socket s = ss.accept();
		InputStream is = s.getInputStream();
		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\Administrator\\Desktop\\Ascall��1.jpg");
		int len;
		byte a[] = new byte[10];
		while ((len = is.read(a)) != -1) {
			fos.write(a, 0, len);
		}
		OutputStream os = s.getOutputStream();
		os.write("���ͳɹ�".getBytes());
		os.close();
		fos.close();
		is.close();
		s.close();
		ss.close();
	}
}
