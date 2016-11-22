package test1;

import java.text.MessageFormat;

public class Teacher {
	private String myName;
	private String mySchool;
	public String getMyName() {
		return myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}
	public String getMySchool() {
		return mySchool;
	}
	public void setMySchool(String mySchool) {
		this.mySchool = mySchool;
	}
	public Teacher(String myName, String mySchool) {
		super();
		this.myName = myName;
		this.mySchool = mySchool;
	}
	public void giveLesson(){
		System.out.println(MessageFormat.format("大家好我叫{0}，来自{1}", myName,mySchool));
	}
	public Teacher(){
		
	}
}
