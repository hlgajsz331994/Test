package com.hlg.Throwable;
/*
 * 编写应用程序,接受命令行的两个参数，要求不能输入负数，计算两数相除。
 * 数据类型不一致(NumberFormatException)、缺少命令行参数(ArrayIndexOutOfBoundsException)、
 * 除0(ArithemeticException)、输入负数(自定义异常)。
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
	static void method(int i , int j){                                //int型初始化为0，Interger初始化为null
		
		try {
			if(i<0 || j<0){
				try {
					throw new EcmDefException("不能为负数");
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
				throw new ArithmeticException("分母不能为0");
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
				throw new ArrayIndexOutOfBoundsException("缺少命令行参数");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
		}
		  catch(NumberFormatException e){
			  try {
				throw new NumberFormatException("数据类型不一致");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
		  }
		
	}

}*/
//改良版
public class EcmDef{                                    
	public static void main(String[] args) {
		try {
			int i = Integer.valueOf(args[0]).intValue();
			int j = Integer.valueOf(args[1]).intValue();
			method(i,j);
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println("缺少命令行参数");
		} catch (ArithmeticException e1){
			System.out.println("除数不能为0");
		} catch (EcmDefException e2){
			System.out.println(e2.getMessage());
		} catch (NumberFormatException e3){
			System.out.println("数据类型不一致");
		}
		
	}
	static void method(int i ,int j){
		if(i<0||j<0){
			throw new EcmDefException("不能为负数");
		}
		System.out.println(i/j);
	}
}
