package com.hlg.Interface;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			IA a = new Student();			/*
											 * 抽象类的实例化，相当于向上转型，访问不到Student类中新建的字段C
											 * 实现的方法是Student中重写的方法
											 * 即使 Student实现了IA的子接口IA1，
											 * 对象a也访问不到IA1的属性和方法
											 */
		
//		System.out.println(a.a);            //继承的IA IB接口中都有a常量
											//接口中的常量可以直接调用 默认为public  static和final
//		IA.Ia();							//接口中的方法就是抽象方法
											//抽象类和接口的区别就是属性可以访问和修改，抽象类可以有非抽象方法
											//接口没有构造函数
											//接口方法的前缀默认为 public abstract
											//抽象类实例化？   匿名内部类型？
		Ic d =null;
		Ic e =new Ic() {
			
			@Override
			public void ic() {
				// TODO Auto-generated method stub
				
			}
		}; 
//		a.a =3;                   //接口的属性对外封闭，不能改变
		
		
		
		
		
	}

}
