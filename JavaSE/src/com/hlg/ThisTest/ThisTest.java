package com.hlg.ThisTest;
/*
 * this 代表你正在构造的对象    ,所以静态方法中不能使用this
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
//		Student d = (Student) b; 		   //向下转型:父类对象指向子类类型       编译不出错，运行出错
		Students e = (Students) c;
		Students f = new Student();			
		f.method();						   //子类对象，父类类型
		e.method();	                       //向上转型：子类对象指向父类类型       损失新的方法	
		
		
		
		
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
		System.out.println("子类方法1");
	}
	void method1(){
		System.out.println("子类方法2");
	}
}
class Students{
	void method(){
		System.out.println("父类方法1");
	}
}