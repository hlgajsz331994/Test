package com.hlg.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//页面传入的数据与web初始化参数进行对比
public class ServletTest1 extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = getServletContext().getInitParameter("user");
		String password = getServletContext().getInitParameter("password");
		
		String htmlUser = req.getParameter("user");
		String htmlPassword = req.getParameter("password");
		
		PrintWriter pw = res.getWriter();
		if(user.equals(htmlUser)&&password.equals(htmlPassword)){
			pw.write("hello"+user);
		}else{
			pw.write("sorry"+user);
		}
//		System.out.println(user+"-"+password+"-"+htmlUser+"-"+htmlPassword);
		
		
	}

	
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	


}
