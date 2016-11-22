package com.hlg.Thread;
/*
 * 模拟火车站窗口，开启三个窗口售票，总票数100张。
 * 隐患：出现线程安全问题（在操作共享数据时，一个线程未结束，另一个线程进入）。
 * 解决方法：线程的同步机制
 * 			一.同步代码块
 * 				synchronized(同步监视器){         
 * 				需要被同步的代码块
 * 				}
 * 				（同步监视器）：锁           哪个线程获取监视器，哪个线程执行代码
 * 			
 * 			二.同步方法
 * 		public synchronized void show(){同步代码块}     //锁是this
 * 
 * 		互斥锁
 *
 */

class TicketWindow extends Thread{
	private static int ticket = 100;               //类变量，三个对象公用一个ticket
	private static int i = 1;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(;i<=100;i++){
			System.out.println(Thread.currentThread().getName()+":"+"出售"+i+"号票,余票"+(ticket-i)+"张");
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
		TicketWindow a = new TicketWindow("1号窗口");
		TicketWindow b = new TicketWindow("2号窗口");
		TicketWindow c = new TicketWindow("3号窗口");
		a.start();
		b.start();
		c.start();
		
		
	}

}
