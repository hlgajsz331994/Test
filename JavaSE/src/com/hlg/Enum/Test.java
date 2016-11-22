package com.hlg.Enum;

public class Test {
	public static void main(String[] args) {
		Season spring = Season.SPRING;
		System.out.println(spring);             //���������ǵ��ö����toString()����                    
		
		
	}											
}
//�Զ���ö����
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
	public static final Season SPRING = new Season("spring","��ů����");
	public static final Season SUNMMER = new Season("summer","��ů����");
	public static final Season AUTUMN = new Season("autumn","��ů����");
	public static final Season WINTER = new Season("winter","��ů����");
	@Override
	public String toString() {
		return "Season [seasonDesc=" + seasonDesc + ", seasonName="
				+ seasonName + "]";
	}
	
}
	

