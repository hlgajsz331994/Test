package com.hlg.Thread;



/*
 * �����ߺ������ߵ�����
 * �����߽���Ʒ������Ա���������ߴӵ�Ա��ȡ�߲�ƽ
 * ��Աһ��ֻ�ܳ��й̶������Ĳ�Ʒ��
 * �����������ͼ��������Ĳ�Ʒ����Ա���ͣ  ��ֱ��������һ����λ���Ż��������߼�������
 * ������ڲ�Ʒ���⣬��Ա�����������´��������ȵ���һ�����Ĳ�Ʒ�� ��֪ͨ������ǰ������
 * 		������
 * 			1.�Ƿ��漰�����̵߳����⣿
 * 			2.�Ƿ��漰��������Դ��                       ע���̰߳�ȫ����
 * 			3.����������˭��
 * 			4.�Ƿ��漰���߳�֮���ͨ�ţ�            wait ��notify/notifyAll
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
		a.setName("�˿�");
		b.setName("����");
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
			System.out.println(Thread.currentThread().getName() + "����һ����Ʒ��ʣ�ࣺ"
					+ products);
		}
		if(products==0){
			System.out.println("�̵���ʱû�����´�����");
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
			System.out.println(Thread.currentThread().getName() + "����һ����Ʒ,ʣ�ࣺ"
					+ products);
		}
		if(products>=10){
			notify();
		}
		if(products==20){
			System.out.println("�̵��������������ͣ����");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}


