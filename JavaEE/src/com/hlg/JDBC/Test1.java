package com.hlg.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Scanner;

import org.junit.Test;

/*
 * �ڿ���̨�������ݣ����嵽���ݿ�ı��У����سɹ�
 *              �ַ���Ҫ��'
 */
public class Test1 {
	@Test
	public void test1() throws Exception {
//		Connection con = TestJDBC1.connection();
//		Statement sta = con.createStatement();
//		JDBCTool.connection();

		String sql = null;
		Student stu = new Student();
		stu.input();
		//��PreparedStatemnt ����  ���в��� ��
		//-- ���Դ����ռλ������䣬���ṩ����ռλ���ķ���,�������
		//-- ���Է�ֹ�û�����ע��
		//-- ����������ܣ�Ԥ������ˣ�ִ��ʱ����Ҫ����sql��
		//"select * from student where user = ''  and  password = '' ;"
		//"select * from student where user = 'a'OR password ='  and  password = 'OR '1'='1' ' ;"
		sql = "INSERT INTO student (name,age,score,class,school) VALUES (?,?,?,?,?);";
		JDBCTool.upadate(sql, stu.name,stu.age,stu.score,stu.clas,stu.school);
//		PreparedStatement pre = con.prepareStatement(sql);     //Ԥ�������
//		pre.setString(1, stu.name);
//		pre.setInt(2, stu.age);
//		pre.setInt(3, stu.score);
//		pre.setInt(4, stu.clas);
//		pre.setString(5, stu.school);
//		pre.execute();
		//ֱ����statement�������
//		sql = MessageFormat
//				.format(
//						"INSERT INTO student (name,age,score,class,school) VALUES ({0},{1},{2},{3},{4});",
//						stu.name,stu.age,stu.score,stu.clas,stu.school);
//		System.out.println(sql);
//		boolean bl = sta.execute(sql);
//		System.out.println(bl);
//		if( bl ){
//			System.out.println("��Ϣ¼��ɹ�");
//		}
//		pre.close();
//		sta.close();
//		con.close();

	}

}
