package com.hlg.Thread;
/*
 * 任意售票窗口售票任意张
 */
class TicketWindow1 implements Runnable{
	static int ticket = 1000;
	static int i =1;
	Object obj = new Object();                    //放在run()方法里，多个线程就不是共用一个锁
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
						+ "出售" + i + "号票,余票" + (ticket - i) + "张");
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
					+ "出售" + i + "号票,余票" + (ticket - i) + "张");
			i++;
		}
	}
}
//TicketWindow1Start 给进程命名，并且开启进程
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
		//实现 Runnable接口的类的对象a
		TicketWindow1 a = new TicketWindow1();
		//窗口数 threadId
		int threadId = 4;
		//储存对象Thread的数组threadArray
		Thread []threadArray = new Thread[threadId];        //实例化对象数组
		for(int i = 0;i<threadArray.length;i++){
			threadArray[i]=new Thread(a);
			threadArray[i].setName((i+1)+"号窗口");
			threadArray[i].start();
		}											
//		TicketWindow1Start ticket = new TicketWindow1Start(threadArray);
		
		
		
		
		
		
	}

}
