package com.hlg.Thread;

public class ThreadTest extends Thread {
	
	
	@Override
	public void run() {
		
		for(int i=1;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
			if(i>22){
				try {
					Thread.currentThread().join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			/*try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
	}
/*	public void run(Thread a) throws InterruptedException{
		for(int i=1;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
			
		}
	}*/

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ThreadTest a = new ThreadTest();
		a.start();
		ThreadTest.currentThread().setName("主线程");
		System.out.println(Thread.currentThread().getPriority());
		for(int i=1;i<100;i++){
			System.out.println(ThreadTest.currentThread().getName()+":"+i);
			if(i==20){
				a.setName("子线程1");
				System.out.println(Thread.currentThread().getName());
//				a.join();
				i++;
			}
		}
	}

}
