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
 * 在控制台输入数据，并插到数据库的表中，返回成功
 *              字符串要加'
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
		//用PreparedStatemnt 对象  进行操作 ，
		//-- 可以传入带占位符的语句，并提供补充占位符的方法,方便操作
		//-- 可以防止用户恶意注入
		//-- 可以提高性能（预编译好了，执行时不需要传入sql）
		//"select * from student where user = ''  and  password = '' ;"
		//"select * from student where user = 'a'OR password ='  and  password = 'OR '1'='1' ' ;"
		sql = "INSERT INTO student (name,age,score,class,school) VALUES (?,?,?,?,?);";
		JDBCTool.upadate(sql, stu.name,stu.age,stu.score,stu.clas,stu.school);
//		PreparedStatement pre = con.prepareStatement(sql);     //预编译好了
//		pre.setString(1, stu.name);
//		pre.setInt(2, stu.age);
//		pre.setInt(3, stu.score);
//		pre.setInt(4, stu.clas);
//		pre.setString(5, stu.school);
//		pre.execute();
		//直接用statement对象操作
//		sql = MessageFormat
//				.format(
//						"INSERT INTO student (name,age,score,class,school) VALUES ({0},{1},{2},{3},{4});",
//						stu.name,stu.age,stu.score,stu.clas,stu.school);
//		System.out.println(sql);
//		boolean bl = sta.execute(sql);
//		System.out.println(bl);
//		if( bl ){
//			System.out.println("信息录入成功");
//		}
//		pre.close();
//		sta.close();
//		con.close();

	}

}
