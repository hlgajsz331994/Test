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
	
	
	//ִ�в�ѯ�Ĳ���
	@Test
	public static void select()throws Exception{
		Connection con = JDBCTool.connection();
	}
	
	//���봫���ռλ������䣬ִ�����ӡ�ɾ�����޸ĵĲ���
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
	
	//ʵ�����ݿ������
	@Test
	public static Connection connection() throws Exception {
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
	//�ر�����
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
