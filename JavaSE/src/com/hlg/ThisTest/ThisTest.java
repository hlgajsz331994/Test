package com.hlg.ThisTest;
/*
 * this ���������ڹ���Ķ���    ,���Ծ�̬�����в���ʹ��this
 * 
 */
public class ThisTest {
		static int i =1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test a = new Test();
		System.out.println(a.toString()+"----3");
		a.Test1();
		a.Test2(); 
		Students b = new Students();
		Student c = new Student();
//		Student d = (Student) b; 		   //����ת��:�������ָ����������       ���벻�������г���
		Students e = (Students) c;
		Students f = new Student();			
		f.method();						   //������󣬸�������
		e.method();	                       //����ת�ͣ��������ָ��������       ��ʧ�µķ���	
		
		
		
		
//		Student g =  new Students();
		/*if(b instanceof c)
		System.out.println();
	}*/
}
}
class Test {
	public Test() {
		System.out.println(this.toString()+"----1");
	}
	void Test1(){
		
		System.out.println(this.toString()+"----2");
	}
	void Test2(){
		Test a = new Test();
		System.out.println(a.toString()+"----4");
	}
}
class Student extends Students{
	void method(){
		System.out.println("���෽��1");
	}
	void method1(){
		System.out.println("���෽��2");
	}
}
class Students{
	void method(){
		System.out.println("���෽��1");
	}
}