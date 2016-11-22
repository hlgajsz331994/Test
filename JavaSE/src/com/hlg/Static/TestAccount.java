package com.hlg.Static;
/*
 * 编写一个类实现银行账户的概念，包含的属性有 ”帐号“，”密码“，”存款余额“，”利率“，”最小余额“。
 * 定义封装这些类，帐号自动生成。
 */
public class TestAccount {
	private int id ;
	private int password;
	private double balance;
	static double rate = 0.05 ;
	static double minBalance = 1;
	private static int init=1000;
	public TestAccount(int password,double balance){
		this.id = init++;
		this.password = password;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "TestAccount [balance=" + balance + ", id=" + id + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
