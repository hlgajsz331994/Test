package com.hlg.Throwable;
/*
 * 自动地抛出   ： 不处理（空指针异常，数组越界异常）
 * 手动抛出： throw+异常类的对象
 * 		>既可以是现成的异常类，也可以是自己创建的
 * 2.手动抛出的异常，若是RuntimeException可以不显现地处理。
 */
public class TestException2 {
	public static void main(String[] args) {
		Circle c1 = new Circle(2.1);
		Circle c2 = new Circle(2.2);
		System.out.println(c1.comparable(c2));
		try {
			System.out.println(c1.comparable(new String ("a")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Circle{
	private  double radius ;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	public int comparable(Object obj) {
		if(this == obj){
			return 0;
		}else if (obj instanceof Circle){
			Circle c = (Circle) obj;
			if(this.radius>c.radius){
				return 1;
			}else if(this.radius == c.radius){
				return 0;
			}else{
				return -1;
			}
		}else {
			//手动抛出一个异常
//			throw new RuntimeException("传入的类型有误");
			
			throw new MyException("传入的类型有误");
//			throw new Exception("传入的类型有误");
			
			/*try {
				throw new Exception("传入的类型有误");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -2;
			}*/
		}
	}
}
