package com.hlg.Thread;
/*
 * ������Ʊ������Ʊ������
 */
class TicketWindow1 implements Runnable{
	static int ticket = 1000;
	static int i =1;
	Object obj = new Object();                    //����run()���������߳̾Ͳ��ǹ���һ����
/*	public void run() {
		// TODO Auto-generated method stub	
		while(true){
		synchronized (obj) {
			if(i<=ticket) {
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ":"
						+ "����" + i + "��Ʊ,��Ʊ" + (ticket - i) + "��");
				i++;
			}
		}
		}
		
	}*/
	public void run(){
		while(true){
			show();
		}
	}
	public synchronized void show(){
		if(i<=ticket) {
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":"
					+ "����" + i + "��Ʊ,��Ʊ" + (ticket - i) + "��");
			i++;
		}
	}
}
//TicketWindow1Start ���������������ҿ�������
class TicketWindow1Start {
	private int i =1;
	public TicketWindow1Start(Thread... a){
		for(Thread b:a){
			b.start();
		}
	}
	}
	
	
public class ThreadWindow1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ʵ�� Runnable�ӿڵ���Ķ���a
		TicketWindow1 a = new TicketWindow1();
		//������ threadId
		int threadId = 4;
		//�������Thread������threadArray
		Thread []threadArray = new Thread[threadId];        //ʵ������������
		for(int i = 0;i<threadArray.length;i++){
			threadArray[i]=new Thread(a);
			threadArray[i].setName((i+1)+"�Ŵ���");
			threadArray[i].start();
		}											
//		TicketWindow1Start ticket = new TicketWindow1Start(threadArray);
		
		
		
		
		
		
	}

}
