package com.hlg.Enum;

public class Test {
	public static void main(String[] args) {
		Season spring = Season.SPRING;
		System.out.println(spring);             //输出对象就是调用对象的toString()方法                    
		
		
	}											
}
//自定义枚举类
interface Info{
	void show();
}
class Season {
	
	private final String seasonName;
	private final String seasonDesc;
	private Season(String seasonName,String seasonDesc){
		this.seasonName=seasonName;
		this.seasonDesc=seasonDesc;
	}
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	public static final Season SPRING = new Season("spring","春暖花开");
	public static final Season SUNMMER = new Season("summer","春暖花开");
	public static final Season AUTUMN = new Season("autumn","春暖花开");
	public static final Season WINTER = new Season("winter","春暖花开");
	@Override
	public String toString() {
		return "Season [seasonDesc=" + seasonDesc + ", seasonName="
				+ seasonName + "]";
	}
	
}
	

