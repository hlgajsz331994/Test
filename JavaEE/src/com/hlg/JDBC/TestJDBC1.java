package com.hlg.JDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;
//com.mysql.jdbc.Driver()  为什么只有静态代码块和一个空的构造器 ？
//                         答：com.mysql.jdbc.Driver的父类中实现了Driver接口的方法。
// Connection con = TestJDBC1.connection();   
// 						：包里有实现Connection接口（重写了方法）的类，返回的就是这些类，

//可以将下面的方法封装起来 成为一个JdbcTool
public class TestJDBC1 {

	/*
	 * 通过connection对象获取Statement对象，之后执行对应的sql语句到对应的数据库中 connection对象（连接）要关闭
	 * Statement对象（连接）要关闭
	 * 
	 * 可以写一个通用的更新方法（传入sql） ：包括   Insert(增)、Delete(删)、Update(改)
	 */
	@Test
	public void Statemnet() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException {

		Connection con = TestJDBC1.connection();
		System.out.println(con);
		//增
		String sql1 = "INSERT INTO score (score,scoreoff,number,abc) VALUES (1234,0.78,3,'开始');";
		//删
		String sql2 = "Delete from score where id=1;";
		//改
		String sql3 = "Update score set score = 123 where id =5; ";
		// 通过connection对象获取Statement对象
		Statement sta = con.createStatement();
		sta.execute(sql1);
		// 关闭连接
		sta.close();
		con.close();
	}

	/*
	 * DriverManager是Driver的管理类
	 * 可以管理多个驱动程序（Driver不可以吗？）（多加载几个驱动程序）（传入参数不同，匹配之后，返回不同的连接）
	 */
	@Test
	public void DriverManager() throws IOException, SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
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

		// 加载数据库驱动(调用forName()方法，自动初始化这个类--mysql的Driver类中的静态代码块，自动加载驱动)
		// java.sql.DriverManager.registerDriver((java.sql.Driver)
		// Class.forName(DriverName).newInstance());
		Class.forName(DriverName);

		// 通过DriverManager获得数据库连接
		Connection con = java.sql.DriverManager.getConnection(jdbcUrl, user,
				password);
	}

	/*
	 * Driver:数据库厂商必须提供实现的接口，能从其中获取数据库的连接. 加入mysql驱动
	 * 1.复制jar包进来，把mysql-jcbc的jar包添加至构建路径 url:"jdbc:子协议:子名称"
	 * 
	 * 如果驱动程序识别出它是连接到给定 URL 的错误类型的驱动程序，那么它应该返回 "null"。 如果要连接到给定 URL
	 * 的驱动程序是正确的驱动程序，但却无法连接到数据库，则该驱动程序应该抛出 SQLException。
	 */
	@Test
	public void Driver() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException {
		// // 获取厂商的Driver实现类
		 java.sql.Driver dr = new com.mysql.jdbc.Driver();                    
		//
		// // 连接数据库的基本信息： url user password
		// String url = "jdbc:mysql://localhost:3306/jdbcdemo"; // 可以连接其他IP的数据库
		// Properties info = new Properties();
		// info.put("user", "root");
		// info.put("password", "root");
		//
		// // 通过实现类的对象获取与数据库的连接
//		 java.sql.Connection connection = dr.connect(url, info);
		// System.out.println(connection);
		// // System.out.println(dr.acceptsURL(url));
		TestJDBC1 jdbc = new TestJDBC1();
		Connection connection = jdbc.connection();
		System.out.println(connection);

	}

	/*
	 * 编写一个类实现所有数据库的连接
	 */
	public static Connection connection() throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, IOException {
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

	@Test
	public void test1() throws FileNotFoundException {
		InputStream is = new FileInputStream("Properties");
	}
}
