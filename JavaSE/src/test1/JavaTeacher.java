package test1;

public class JavaTeacher extends Teacher {
	private String myName;
	

	
	public void setMyName(String myName) {
		this.myName = myName;
	}
	public JavaTeacher(String myName, String mySchool) {
//		super(myName, mySchool);
		// TODO Auto-generated constructor stub
//		super.giveLesson();
		this.setMyName(myName);
		this.myName="a";
		
	}
	public JavaTeacher(){
		
	}

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaTeacher a = new JavaTeacher("°ÂÌØÂü", "M78ÐÇÔÆ");
		/*JavaTeacher b = new JavaTeacher();
		System.out.println(b.getMyName());*/
		System.out.println(a.getMyName());
	}

}
