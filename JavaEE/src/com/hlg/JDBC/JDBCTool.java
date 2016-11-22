package com.hlg.JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class JDBCTool {
	
	
	//执行查询的操作
	@Test
	public static void select()throws Exception{
		Connection con = JDBCTool.connection();
	}
	
	//传入传入带占位符的语句，执行增加、删除、修改的操作
	@Test
	public static void upadate ( String sql,Object ... args) throws Exception{
		Connection con = JDBCTool.connection();
		PreparedStatement pre = con.prepareStatement(sql);
		for(int i = 0;i<args.length;i++){
			pre.setObject(i+1, args[i]);
		}
		pre.execute();
		JDBCTool.closeDB(con, null, pre);
		
		
		
	}
	
	//实现数据库的连接
	@Test
	public static Connection connection() throws Exception {
		String DriverName = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;

		// 获取文件流，把流加入Properties，获取流中的数据
		InputStream is = new FileInputStream("src/Properties");
		Properties pro = new Properties();
		pro.load(is);
		DriverName = pro.getProperty("Driver");
		jdbcUrl = pro.getProperty("jdbcUrl");
		user = pro.getProperty("user");
		password = pro.getProperty("password");

		// 反射获得Driver对象
		Properties info = new Properties();
		info.put("user", user);
		info.put("password", password);
		Connection connection = ((java.sql.Driver) Class.forName(DriverName)
				.newInstance()).connect(jdbcUrl, info);

		return connection;

	}
	//关闭连接
	public static void closeDB(Connection con ,Statement sta,PreparedStatement pre) throws Exception{
		if(con!=null){
			con.close();
		}
		if(sta!=null){
			sta.close();
		}
		if(pre!=null){
			pre.close();
		}
	}
}
