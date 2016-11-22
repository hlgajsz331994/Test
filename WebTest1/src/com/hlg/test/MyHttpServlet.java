package com.hlg.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//实现HttpServlet类的过程
public abstract class MyHttpServlet extends MyGenericServlet {

	

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
				// TODO Auto-generated method stub
				if (req instanceof HttpServletRequest) {
					HttpServletRequest httpRequest = (HttpServletRequest) req;

			if (res instanceof HttpServletResponse) {
				HttpServletResponse httpResponse = (HttpServletResponse) res;
				service(httpRequest, httpResponse);
			}
		}

	}
	
	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			doGet(req, res);
		}
		if (req.getMethod().equalsIgnoreCase("Post")) {
			doPost(req, res);
		}
	}

	public abstract void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	public abstract void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;

}
