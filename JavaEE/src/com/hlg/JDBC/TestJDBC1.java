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
//com.mysql.jdbc.Driver()  Ϊʲôֻ�о�̬������һ���յĹ����� ��
//                         ��com.mysql.jdbc.Driver�ĸ�����ʵ����Driver�ӿڵķ�����
// Connection con = TestJDBC1.connection();   
// 						��������ʵ��Connection�ӿڣ���д�˷��������࣬���صľ�����Щ�࣬

//���Խ�����ķ�����װ���� ��Ϊһ��JdbcTool
public class TestJDBC1 {

	/*
	 * ͨ��connection�����ȡStatement����֮��ִ�ж�Ӧ��sql��䵽��Ӧ�����ݿ��� connection�������ӣ�Ҫ�ر�
	 * Statement�������ӣ�Ҫ�ر�
	 * 
	 * ����дһ��ͨ�õĸ��·���������sql�� ������   Insert(��)��Delete(ɾ)��Update(��)
	 */
	@Test
	public void Statemnet() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException {

		Connection con = TestJDBC1.connection();
		System.out.println(con);
		//��
		String sql1 = "INSERT INTO score (score,scoreoff,number,abc) VALUES (1234,0.78,3,'��ʼ');";
		//ɾ
		String sql2 = "Delete from score where id=1;";
		//��
		String sql3 = "Update score set score = 123 where id =5; ";
		// ͨ��connection�����ȡStatement����
		Statement sta = con.createStatement();
		sta.execute(sql1);
		// �ر�����
		sta.close();
		con.close();
	}

	/*
	 * DriverManager��Driver�Ĺ�����
	 * ���Թ�������������Driver�������𣿣�������ؼ����������򣩣����������ͬ��ƥ��֮�󣬷��ز�ͬ�����ӣ�
	 */
	@Test
	public void DriverManager() throws IOException, SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		String DriverName = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;

		// ��ȡ�ļ�������������Properties����ȡ���е�����
		InputStream is = new FileInputStream("src/Properties");
		Properties pro = new Properties();
		pro.load(is);
		DriverName = pro.getProperty("Driver");
		jdbcUrl = pro.getProperty("jdbcUrl");
		user = pro.getProperty("user");
		password = pro.getProperty("password");

		// �������ݿ�����(����forName()�������Զ���ʼ�������--mysql��Driver���еľ�̬����飬�Զ���������)
		// java.sql.DriverManager.registerDriver((java.sql.Driver)
		// Class.forName(DriverName).newInstance());
		Class.forName(DriverName);

		// ͨ��DriverManager������ݿ�����
		Connection con = java.sql.DriverManager.getConnection(jdbcUrl, user,
				password);
	}

	/*
	 * Driver:���ݿ⳧�̱����ṩʵ�ֵĽӿڣ��ܴ����л�ȡ���ݿ������. ����mysql����
	 * 1.����jar����������mysql-jcbc��jar�����������·�� url:"jdbc:��Э��:������"
	 * 
	 * �����������ʶ����������ӵ����� URL �Ĵ������͵�����������ô��Ӧ�÷��� "null"�� ���Ҫ���ӵ����� URL
	 * ��������������ȷ���������򣬵�ȴ�޷����ӵ����ݿ⣬�����������Ӧ���׳� SQLException��
	 */
	@Test
	public void Driver() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException {
		// // ��ȡ���̵�Driverʵ����
		 java.sql.Driver dr = new com.mysql.jdbc.Driver();                    
		//
		// // �������ݿ�Ļ�����Ϣ�� url user password
		// String url = "jdbc:mysql://localhost:3306/jdbcdemo"; // ������������IP�����ݿ�
		// Properties info = new Properties();
		// info.put("user", "root");
		// info.put("password", "root");
		//
		// // ͨ��ʵ����Ķ����ȡ�����ݿ������
//		 java.sql.Connection connection = dr.connect(url, info);
		// System.out.println(connection);
		// // System.out.println(dr.acceptsURL(url));
		TestJDBC1 jdbc = new TestJDBC1();
		Connection connection = jdbc.connection();
		System.out.println(connection);

	}

	/*
	 * ��дһ����ʵ���������ݿ������
	 */
	public static Connection connection() throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, IOException {
		String DriverName = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;

		// ��ȡ�ļ�������������Properties����ȡ���е�����
		InputStream is = new FileInputStream("src/Properties");
		Properties pro = new Properties();
		pro.load(is);
		DriverName = pro.getProperty("Driver");
		jdbcUrl = pro.getProperty("jdbcUrl");
		user = pro.getProperty("user");
		password = pro.getProperty("password");

		// ������Driver����
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
