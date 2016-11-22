package com.hlg.Thread;
class  RunnableTest implements Runnable {
	public void run() {
		for(int i=1;i<100;i++){
			System.out.println(ThreadTest.currentThread().getName()+":"+i);
		}
	}
}
public class ThreadRunnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableTest a = new RunnableTest();
		Thread b = new Thread(a);
		b.start();

	}

}
