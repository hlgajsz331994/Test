package com.hlg.Thread;
class SubThread1 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<50;i++){
			System.out.println(2*i+1);
		}
	}
	public SubThread1(String name ){
		super(name);
	}
}
class SubThread2 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=1;i<=50;i++){
			System.out.println(2*i);
		}
	}
	public SubThread2(String name){
		super(name);                              //��name��������
	}
}
public class ThreadTest1  {
	
	public static void main(String []args){
		SubThread1 a = new SubThread1("�߳�1:");
		SubThread2 b = new SubThread2("�߳�2:");
		a.start();
		b.start();
		String c = "a";
		//�̳���Thread�����������
		/*new Thread(){
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				for(int i=0;i<100;i++){
					if(i%2 != 0){
						System.out.println(Thread.currentThread().getName()+":"+i);
					}
				}
			}
		}.start();
		new Thread(){
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				for(int i=0;i<100;i++){
					if(i%2 == 0){
						System.out.println(Thread.currentThread().getName()+":"+i);
					}
				}
			}
		}.start();*/
	}
	
	
}
