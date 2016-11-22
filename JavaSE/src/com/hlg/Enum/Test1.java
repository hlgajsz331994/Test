package com.hlg.Enum;

public class Test1 {
/*
 * 1.values() 返回枚举类所有对象到数组 
 * 2.valueOf(String name ) 传入具体名称，返回该名称对应的对象。 
 * 3.还是可以通过类名直接调用对象
 * 4.与单例模式相似
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
enum Season1 implements Info1{                      //enum 实现接口 
	SPRING("spring","春暖花开"){
		public void show(){
			System.out.println("a");
		}
	},
	SUMMER("summer","春暖花开"){
		public void show(){
			System.out.println("a");
		}
	},
	AUTUMN("autumn","春暖花开"){
		public void show(){
			System.out.println("a");
		}
	},
	WINTER("winter","春暖花开"){
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
