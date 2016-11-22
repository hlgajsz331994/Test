package com.hlg.DesginPattern1;
  //懒汉式 线程安全问题
public class SingletonTest1 {
	
		private SingletonTest1(){}
		private static SingletonTest1 instance ;
		public static SingletonTest1 getInstance(){
			if (instance == null) {                              //多线程，执行效率变高？
				synchronized (SingletonTest.class) { //反射机制？
					if (instance == null) {
						instance = new SingletonTest1();
					}
				}
			}
			return instance;
		}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
