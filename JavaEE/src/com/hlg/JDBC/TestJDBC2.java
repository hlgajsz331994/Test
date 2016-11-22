package com.hlg.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;
	//查询
public class TestJDBC2 {
	@Test
	public void select()throws Exception{
		Connection con = TestJDBC1.connection();
		Statement sta = con.createStatement();
		
		/*
		 * 返回的就是一张数据表
		 * ResultSet 对象具有指向其当前数据行的光标。最初，光标被置于第一行之前。next 方法将光标移动到下一行；
		 * 因为该方法在 ResultSet 对象没有下一行时返回 false，所以可以在 while 循环中使用它来迭代结果集。
		 *  .getxxx(int i);制定列        .getxxx(String name):指定字段的值
		 *   ResultSet需要关闭
		 */
		//在控制台打印出number为2的总分
		String sql = "SELECT number,SUM(score) AS '总分' FROM score GROUP BY number;";
		ResultSet res = sta.executeQuery(sql);        //列从1开始编号
		long sum = 0;
		while(res.next()){                          //先next，查看有无数据
			if(res.getInt("number")==2){
				sum = res.getLong("总分");
				System.out.println(sum);
			}
			};
		
		res.close();
		sta.close();
		con.close();
	}
}
