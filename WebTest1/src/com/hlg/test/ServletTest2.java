package com.hlg.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//将页面信息与数据库中的信息进行对比
public class ServletTest2 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		
		Connection con = null;
		Statement sta = null;
		ResultSet res = null;
		String sql = "SELECT *  FROM user ;";
		try {
			 con = JDBCTool.connection();
			 sta = con.createStatement();
			 res = sta.executeQuery(sql);
			 while(res.next()){
					if(res.getString("user").equals(user)){
						if(res.getString("password").equals(password)){
							System.out.println(res.getInt("id")+" 用户登录成功");
						}
					}
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
