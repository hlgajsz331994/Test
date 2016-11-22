package test1;

public class Demo1 {
	int a = 1;
	int b = 2;
	int c = 3;
	public  void demo1(){
		int a =10;
		int e =a;
		System.out.println(e);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		demo1();
		/*Demo1 demo1 = new Demo1();
		Demo1 demo2 = new Demo1();
		demo1.demo2(demo1);
		System.out.println(demo1.a);*/
		Demo1 demo1 = new Demo1();
		demo1.demo1();
	}
	public void demo2(final Demo1 a){
		demo1();
		this.demo1();
		a.a=11;
		
		
		
	}

}
