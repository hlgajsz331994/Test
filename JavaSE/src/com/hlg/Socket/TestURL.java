package com.hlg.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

/*
 * URL：统一资源定位符，一个URL的对象，对应着互联网上的一个资源。
 * 我们可以通过URL的对象调用其相应的方法，将此资源读取（“下载”）
 * 
 * 
 */
public class TestURL {
	@Test
	public void test1() throws IOException{
		URL url = new URL("http://localhost/aa/HelloWorld.txt");
		System.out.println(url.getProtocol());      //获取协议
		System.out.println(url.getHost());			//获取主机名
		System.out.println(url.getPort());			//获取端口	
		System.out.println(url.getFile());			//获取文件名
		System.out.println(url.getRef());   		//获取该URL在文件中的相对位置
		System.out.println(url.getQuery());     	//获取该URL的查询名
		//如何将服务端的的资源读取进来
		InputStream is = url.openStream();
		int len;
		byte []b= new byte[20];
		while((len=is.read(b))!=-1){
			String str = new String(b,0,len);
			System.out.print(str);
		}
		//如何既有数据的输入，又有数据的输出
		URLConnection u = url.openConnection();
		
	}
}
