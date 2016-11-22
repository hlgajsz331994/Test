package com.hlg.Reflex;

class Ppd{
	
}
interface AAbc{
	
}
public class Person extends Ppd implements AAbc{
	 public String name;
	 private int age;
	 
	 public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	 Person(){}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "ReflexTest [age=" + age + ", name=" + name + "]";
	}
	public static void main(String[] args) {
	}
}
