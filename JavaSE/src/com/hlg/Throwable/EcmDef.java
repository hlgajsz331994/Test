package com.hlg.Throwable;
/*
 * ��дӦ�ó���,���������е�����������Ҫ�������븺�����������������
 * �������Ͳ�һ��(NumberFormatException)��ȱ�������в���(ArrayIndexOutOfBoundsException)��
 * ��0(ArithemeticException)�����븺��(�Զ����쳣)��
 * 
 *
 */
class EcmDefException extends RuntimeException{
	private static final long serialVersionUID = 2256477558314496007L;
	 public  EcmDefException(String s ) {
		// TODO Auto-generated constructor stub
		 super(s);
	}
}
/*public class EcmDef {

	*//**
	 * @param args
	 *//*
	static void method(int i , int j){                                //int�ͳ�ʼ��Ϊ0��Interger��ʼ��Ϊnull
		
		try {
			if(i<0 || j<0){
				try {
					throw new EcmDefException("����Ϊ����");
				} catch (EcmDefException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}else{
			int a= i/j;
			System.out.println(a);
			}
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			try {
				throw new ArithmeticException("��ĸ����Ϊ0");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer i = null;
//		Integer j = null;
		try {
			int i = Integer.valueOf(args[0]).intValue();
			int j = Integer.valueOf(args[1]).intValue();
			method(i,j);
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			try {
				throw new ArrayIndexOutOfBoundsException("ȱ�������в���");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
		}
		  catch(NumberFormatException e){
			  try {
				throw new NumberFormatException("�������Ͳ�һ��");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
		  }
		
	}

}*/
//������
public class EcmDef{                                    
	public static void main(String[] args) {
		try {
			int i = Integer.valueOf(args[0]).intValue();
			int j = Integer.valueOf(args[1]).intValue();
			method(i,j);
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println("ȱ�������в���");
		} catch (ArithmeticException e1){
			System.out.println("��������Ϊ0");
		} catch (EcmDefException e2){
			System.out.println(e2.getMessage());
		} catch (NumberFormatException e3){
			System.out.println("�������Ͳ�һ��");
		}
		
	}
	static void method(int i ,int j){
		if(i<0||j<0){
			throw new EcmDefException("����Ϊ����");
		}
		System.out.println(i/j);
	}
}
