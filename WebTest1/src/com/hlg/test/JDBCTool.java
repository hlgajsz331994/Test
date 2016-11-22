package com.hlg.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTool {
	

	public static Connection connection() throws Exception{
		String DriverName = "com.mysql.jdbc.Driver";
		String jdbcUrl = "jdbc:mysql://localhost:3306/jdbcdemo1";
		String user = "root";
		String password = "root";
		
		Class.forName(DriverName);
		Connection connection = java.sql.DriverManager.getConnection(jdbcUrl, user,
				password);
		return connection;
	}
}
