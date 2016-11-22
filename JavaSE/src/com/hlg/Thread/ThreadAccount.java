package com.hlg.Thread;
//两个储户分别往同一个账户中存3000，一次存1000。
// 共享数据，同一个账户
//两个储户往同一个账户存钱
public class ThreadAccount{
	public static void main(String[] args) {
		Customer a = new Customer(5,1000);
		Thread customer1 = new Thread(a) ;
		Thread customer2 = new Thread(a);
		
		/*Customer customer1 = new Customer(5,1000);
		Customer customer2 = new Customer(5,1000);
		System.out.println(customer1.account == customer2.account);*/
		customer1.setName("储户一");
		customer2.setName("储户二");
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
					System.out.println(Thread.currentThread().getName() + "存钱"
							+ money + "\t余额：" + instance);
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
	//time：存款次数    money：每次存款金额 
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
	


