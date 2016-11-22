package test;

public interface Pair1 {
	public void student();
	public void student1(); 
	public   int O =1;
	public interface Pair11{
		static final int O =2;
		public void student2();               //实现接口Pair1  不会实现接口Pair11的方法
	}
}
