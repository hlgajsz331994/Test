package com.hlg.test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


//实现GenericServlet类的过程
public abstract class MyGenericServlet implements Servlet,ServletConfig {

	@Override
	public abstract void destroy() ;

		@Override
		public ServletConfig getServletConfig() {
			return config;
		}

		@Override
		public abstract String getServletInfo();
		private ServletConfig config;
		@Override
		public void init(ServletConfig config) throws ServletException {
			System.out.println("---MyGenericServlet---init");
			this.config = config;
			this.init();
	}
	public void init() throws ServletException{
		System.out.println("MyGenericServlet ---- init()");
	}

	@Override
	public abstract void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException ;
		
	//实现接口ServletConfig的方法
	@Override
	public String getInitParameter(String arg0) {
		// TODO Auto-generated method stub
		return config.getInitParameter(arg0);
	}

	@Override
	public Enumeration getInitParameterNames() {
		// TODO Auto-generated method stub
		return config.getInitParameterNames();
	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return config.getServletContext();
	}

	@Override
	public String getServletName() {
		// TODO Auto-generated method stub
		return config.getServletName();
	}

}
