package com.hlg.Throwable;
/*
 * �Զ���һ���쳣��:
 * 1.�Զ�����쳣��̳����е��쳣�ࡣ
 * 2.�ṩһ�����кţ��ṩ�������صĹ�������
 * 
 * ������д�ĸ��෽�������׳����쳣��ֻ���Ǹ��෽���׳����쳣����������쳣��һ����
*/
public class TestException3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	

}
class MyException extends RuntimeException{
	  static final long serialVersionUID = -703490745766939L;

	public MyException(String a) {
		super(a);
	}
	  
	  
}
