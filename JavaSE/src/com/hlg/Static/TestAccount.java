package com.hlg.Static;
/*
 * ��дһ����ʵ�������˻��ĸ�������������� ���ʺš��������롰����������������ʡ�������С����
 * �����װ��Щ�࣬�ʺ��Զ����ɡ�
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
