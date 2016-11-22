package com.hlg.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ServletTest implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("----destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("----getServletConfig");
		return null;
	}

	//实例完后，调用init（）来进行初始化   Servlet容器把参数放到ServletConfig的一个对象里面去
	@Override
	public void init(ServletConfig config) throws ServletException {
			// TODO Auto-generated method stub
			System.out.println("----init");
		String user = config.getInitParameter("user");
		System.out.println("user:"+user);

		Enumeration<String> en =config.getInitParameterNames();
		while(en.hasMoreElements()){
			String name = en.nextElement();
			System.out.println("name:"+name);
			String value = config.getInitParameter(name);
			System.out.println("value:"+value);
		}
		System.out.println("-------------");
		ServletContext context = config.getServletContext();
		String name = context.getInitParameter("driver");
		System.out.println("name:"+name);

		String url = context.getRealPath("/hello.jsp");
		System.out.println("url:"+url);
		System.out.println("-------------");
		String webName = context.getContextPath();
		System.out.println("webName:" + webName);

	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("----getServletInfo");
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("----servic");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)req;
		String requestURI = httpServletRequest.getRequestURI();
		System.out.println("requestURI:"+requestURI);
		
//		res.setContentType("application/msword");
		PrintWriter pw = res.getWriter();
		pw.write("helloworld");
		
	}
	public ServletTest(){
		System.out.println("----constructor");
	}

	
}
