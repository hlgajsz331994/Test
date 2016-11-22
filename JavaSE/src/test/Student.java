package test;

import test.Pair1.Pair11;

public  class Student implements Comparable<Student>,Pair1,Pair11 {
	private int stuNo;
	private String stuName;
	private Integer stuAge;
	static final int stuA = 1;
	int stuB =5;

	public int getStuNo() {
		return stuNo;
		 
	}
	/*public void test (){
		int c = this.stuA;
	}*/
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	

	@Override
	public String toString() {
		return "Student [stuAge=" + stuAge + ", stuName=" + stuName
				+ ", stuNo=" + stuNo + "]";
	}
	public Student(){
		
	}
	public Student(int stuNo, String stuName, int stuAge) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuAge = stuAge;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int compareTo(Student o) {
		/*if(!(o instanceof Student)){
			return -1;
		}
		Student otherStudent = (Student) o;
		if (this.stuAge > otherStudent.stuAge) {
			return 1;
		} else if (this.stuAge < otherStudent.stuAge) {
			return -1;
		}else{
			return 0;
		}*/
		return this.stuAge.compareTo(o.stuAge);
	}

	public void student2() {
		// TODO Auto-generated method stub
		
	}

	public void student() {
		// TODO Auto-generated method stub
		
	}

	public void student1() {
		// TODO Auto-generated method stub
		
	}


	



	

	

}
