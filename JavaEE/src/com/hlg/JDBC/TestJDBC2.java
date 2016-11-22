package com.hlg.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;
	//��ѯ
public class TestJDBC2 {
	@Test
	public void select()throws Exception{
		Connection con = TestJDBC1.connection();
		Statement sta = con.createStatement();
		
		/*
		 * ���صľ���һ�����ݱ�
		 * ResultSet �������ָ���䵱ǰ�����еĹ�ꡣ�������걻���ڵ�һ��֮ǰ��next ����������ƶ�����һ�У�
		 * ��Ϊ�÷����� ResultSet ����û����һ��ʱ���� false�����Կ����� while ѭ����ʹ�����������������
		 *  .getxxx(int i);�ƶ���        .getxxx(String name):ָ���ֶε�ֵ
		 *   ResultSet��Ҫ�ر�
		 */
		//�ڿ���̨��ӡ��numberΪ2���ܷ�
		String sql = "SELECT number,SUM(score) AS '�ܷ�' FROM score GROUP BY number;";
		ResultSet res = sta.executeQuery(sql);        //�д�1��ʼ���
		long sum = 0;
		while(res.next()){                          //��next���鿴��������
			if(res.getInt("number")==2){
				sum = res.getLong("�ܷ�");
				System.out.println(sum);
			}
			};
		
		res.close();
		sta.close();
		con.close();
	}
}
