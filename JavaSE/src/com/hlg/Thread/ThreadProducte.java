package com.hlg.Thread;



/*
 * 生产者和消费者的问题
 * 生产者将产品交给店员，而消费者从店员处取走铲平
 * 店员一次只能持有固定数量的产品，
 * 如果生产者试图生产更多的产品，店员会叫停  ，直到店内有一定空位，才会让生产者继续生产
 * 如果店内产品卖光，店员会让消费者下次再来，等到有一定量的产品， 再通知消费者前来购买
 * 		分析：
 * 			1.是否涉及到多线程的问题？
 * 			2.是否涉及到共享资源？                       注意线程安全问题
 * 			3.共享数据是谁？
 * 			4.是否涉及到线程之间的通信？            wait ，notify/notifyAll
 */			
public class ThreadProducte {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clerk cle= new Clerk();
		Customers cus = new Customers(cle);
		Producter pro = new Producter(cle);
		Thread a = new Thread(cus);
		Thread b = new Thread(pro);
		a.setName("顾客");
		b.setName("厂家");
		a.start();
		b.start();
	}
}

class Customers implements Runnable {
	Clerk clerk ;
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			clerk.getProducts();
		}
	}
	public Customers(Clerk a ){
		this.clerk=a;
	}
}

class Producter implements Runnable {
	
	Clerk clerk;
	public void run() {
		while (true) {
			// TODO Auto-generated method stub
			clerk.setProducts();
		}
	}
	public Producter(Clerk a ){
		this.clerk = a;
}
}

class Clerk {
	static int products = 20;
	
	 synchronized void getProducts() {
		 try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if (products > 0) {

			products--;
			System.out.println(Thread.currentThread().getName() + "拿走一件商品，剩余："
					+ products);
		}
		if(products==0){
			System.out.println("商店暂时没货请下次再来");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(products<=10){
			notify();
		}

	}

	 synchronized void setProducts() {
		 try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if (products < 20) {
			products++;
			System.out.println(Thread.currentThread().getName() + "存入一件商品,剩余："
					+ products);
		}
		if(products>=10){
			notify();
		}
		if(products==20){
			System.out.println("商店货物已满，请暂停生产");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}


