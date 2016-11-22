package com.hlg.Enum;

public class Test1 {
/*
 * 1.values() ����ö�������ж������� 
 * 2.valueOf(String name ) ����������ƣ����ظ����ƶ�Ӧ�Ķ��� 
 * 3.���ǿ���ͨ������ֱ�ӵ��ö���
 * 4.�뵥��ģʽ����
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Season1 c[] = Season1.values();
		for(int i=0;i<c.length;i++){
			System.out.println(c[i]);
		}
		Season1 a = Season1.AUTUMN;
		Season1 b = Season1.valueOf("SPRING");
		System.out.println(b);
		
	}

}
interface Info1{
	void show();
}
enum Season1 implements Info1{                      //enum ʵ�ֽӿ� 
	SPRING("spring","��ů����"){
		public void show(){
			System.out.println("a");
		}
	},
	SUMMER("summer","��ů����"){
		public void show(){
			System.out.println("a");
		}
	},
	AUTUMN("autumn","��ů����"){
		public void show(){
			System.out.println("a");
		}
	},
	WINTER("winter","��ů����"){
		public void show(){
			System.out.println("a");
		}
	};
	private final String seasonName;
	private final String seasonDesc;
	private Season1(String seasonName,String seasonDesc ){
		this.seasonName=seasonName;
		this.seasonDesc=seasonDesc;
	}
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	public String toString(){
		return "Season1 [seasonDesc=" + seasonDesc + ", seasonName="
		+ seasonName + "]";
	}
	
	
	
}
