package com.hlg.JDBC;

import java.util.Scanner;

import org.junit.Test;

public class Student {
	
	String name;
	int age;
	int score;
	int clas;
	String school;
	@Test
	public void input(){
		Scanner sca = new Scanner(System.in);
		System.out.println("请输入学生的详细信息");
		System.out.print("name:");
		name = "'"+sca.nextLine()+"'";
		System.out.print("age:");
		age = Integer.valueOf(sca.nextLine());
		System.out.print("score:");
		score = Integer.valueOf(sca.nextLine());
		System.out.print("class:");
		clas = Integer.valueOf(sca.nextLine());
		System.out.print("school:");
		school ="'"+ sca.nextLine()+"'";
		
		
		
	}
}
