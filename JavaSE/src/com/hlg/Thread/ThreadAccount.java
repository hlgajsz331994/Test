package com.hlg.Thread;
//���������ֱ���ͬһ���˻��д�3000��һ�δ�1000��
// �������ݣ�ͬһ���˻�
//����������ͬһ���˻���Ǯ
public class ThreadAccount{
	public static void main(String[] args) {
		Customer a = new Customer(5,1000);
		Thread customer1 = new Thread(a) ;
		Thread customer2 = new Thread(a);
		
		/*Customer customer1 = new Customer(5,1000);
		Customer customer2 = new Customer(5,1000);
		System.out.println(customer1.account == customer2.account);*/
		customer1.setName("����һ");
		customer2.setName("������");
		customer1.start();
		customer2.start();
	}
}
class Account{
	private double instance;
	void deposit(int time,double money ){
		int i =0;
		while (true) {
			synchronized (this) {
				notify();
				if (i < time) {
					instance += money;
					System.out.println(Thread.currentThread().getName() + "��Ǯ"
							+ money + "\t��" + instance);
					i++;
				}else{break;}
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
 class Customer implements Runnable {
	private int time;
	private double money;
	Account account =new Account();
	//time��������    money��ÿ�δ���� 
	public Customer(int time, double money) {
		super();
		this.time = time;
		this.money = money;
		
	}

	public void run() {
		// TODO Auto-generated method stub
			System.out.println(account);                
			account.deposit(time,money);
		}
	}
/*class Customer extends Thread {
	private int time;
	private double money;
	Account account = new Account();
	
	public Customer(int time, double money) {
		super();
		this.time = time;
		this.money = money;
		
	}

	public void run() {
		// TODO Auto-generated method stub
			System.out.println(account);
			account.deposit(time,money);
		}
	}
	*/
	


