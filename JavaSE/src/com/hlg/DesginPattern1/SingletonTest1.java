package com.hlg.DesginPattern1;
  //����ʽ �̰߳�ȫ����
public class SingletonTest1 {
	
		private SingletonTest1(){}
		private static SingletonTest1 instance ;
		public static SingletonTest1 getInstance(){
			if (instance == null) {                              //���̣߳�ִ��Ч�ʱ�ߣ�
				synchronized (SingletonTest.class) { //������ƣ�
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
