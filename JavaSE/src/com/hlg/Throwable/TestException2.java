package com.hlg.Throwable;
/*
 * �Զ����׳�   �� ��������ָ���쳣������Խ���쳣��
 * �ֶ��׳��� throw+�쳣��Ķ���
 * 		>�ȿ������ֳɵ��쳣�࣬Ҳ�������Լ�������
 * 2.�ֶ��׳����쳣������RuntimeException���Բ����ֵش���
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
			//�ֶ��׳�һ���쳣
//			throw new RuntimeException("�������������");
			
			throw new MyException("�������������");
//			throw new Exception("�������������");
			
			/*try {
				throw new Exception("�������������");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -2;
			}*/
		}
	}
}
