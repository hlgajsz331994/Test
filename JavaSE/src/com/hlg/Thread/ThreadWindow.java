package com.hlg.Thread;
/*
 * ģ���վ���ڣ���������������Ʊ����Ʊ��100�š�
 * �����������̰߳�ȫ���⣨�ڲ�����������ʱ��һ���߳�δ��������һ���߳̽��룩��
 * ����������̵߳�ͬ������
 * 			һ.ͬ�������
 * 				synchronized(ͬ��������){         
 * 				��Ҫ��ͬ���Ĵ����
 * 				}
 * 				��ͬ��������������           �ĸ��̻߳�ȡ���������ĸ��߳�ִ�д���
 * 			
 * 			��.ͬ������
 * 		public synchronized void show(){ͬ�������}     //����this
 * 
 * 		������
 *
 */

class TicketWindow extends Thread{
	private static int ticket = 100;               //�����������������һ��ticket
	private static int i = 1;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(;i<=100;i++){
			System.out.println(Thread.currentThread().getName()+":"+"����"+i+"��Ʊ,��Ʊ"+(ticket-i)+"��");
		}
	}
	public TicketWindow(String name ){
		super(name);
	}
	
}
public class ThreadWindow {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketWindow a = new TicketWindow("1�Ŵ���");
		TicketWindow b = new TicketWindow("2�Ŵ���");
		TicketWindow c = new TicketWindow("3�Ŵ���");
		a.start();
		b.start();
		c.start();
		
		
	}

}
