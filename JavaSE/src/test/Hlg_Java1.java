package test;

import java.awt.SystemColor;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Hlg_Java1 {
	static String c="abc";
	public Hlg_Java1() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		                                      //intern用法
	/*	String a="123";
		String b=new String("123");
		String c="123";
		String d = null;
		String e=new String("kvill");
		String f=new String("kvill");
		b.intern();
		System.out.println(a==b.intern());
		System.out.println(a==c);*/
		                                     //Scanner用法
		/*String name;
		double sum=0;
		Scanner input=new Scanner(System.in); 
		System.out.print("请输入学生姓名：");
		name=input.nextLine();
		while(true){
			for(int i=1;i<=5;i++){
				
				
				System.out.print("请输入五门功课第"+i+"门课的成绩：");
				int score;
				score=input.nextInt();
				sum=sum+score;
			}
			break;
		}
		System.out.println(name+"的平均分是："+sum/5);
		*/
		
		                                       //Scanner练习
		/*int i;
		int score;
		int geshu=0;
		double bili=0;
		Scanner input = new Scanner(System.in);
		System.out.print("输入班级总人数:");
		i=input.nextInt();
		for(int j=0;j<i;j++){
			System.out.print("请输入第"+(j+1)+"位学生的成绩: ");
			score=input.nextInt();
			if(score>=80){
				geshu++;
			}
		}
		System.out.println("80分以上的学生人数是:"+geshu);
		bili=(double)geshu/i;                                                  //int型转Double
		System.out.println("80分以上的学生所占的比例为:"+bili*100+"%");
		*/
		
		/*System.out.print("我们\t123");    //\t相当于缩进
*/		
		/*int i;
		System.out.println("*************************************************************");
		System.out.println("*                        1.登录系统                                                                    *");
		System.out.println("*                                                           *");
		System.out.println("*                        2.退出                                                                              *");
		System.out.println("*************************************************************");
		System.out.println("请选择，输入数字：");
		Scanner input = new Scanner(System.in);
		i=input.nextInt();*/
		
		/*double a=1.2;
		int b=(int)a;
		System.out.println(b);   //大类型给小类型赋值需要转换
*/		
		/*int a=1;
		switch(a){
		case 1:
			break;
		case 2:
		case 3: 								//重复Switch
		case 4:
			System.out.println(a);
			break;
		default:System.out.println(5);
		}*/
		
	/*	for(int i=0;i<=10;i++){
			if(i>5){
//				break;
				return;                     //break跳出当前循环，return跳出整个主函数
			}
			System.out.println(i);
		}
		System.out.println("End");
		*/
		/*int[] nums={1,2,3,4,5,6};
		System.out.println("数组长度为:"+nums.length);    //数组长度
		*/
	/*	String a[]=new String[3];
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}*/
/*		Scanner input=new Scanner(System.in);
		System.out.print("请输入四位会员卡卡号：");
		int card=input.nextInt();
		int khh=card/1000+card/100%10+card/10%10+card%10;
		System.out.println(card/1000);
		System.out.println(card/100%10);
		System.out.println(card/10%10);
		System.out.println(card%10);
		System.out.print("会员卡号"+card+"各位之和:"+khh);*/
/*		String a = "123";
		String b = "123";
		String c = new String("123");
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));*/
		/*
		 * Scanner input=new Scanner(System.in); System.out.print("请输入邮箱帐号：");
		 * String email=input.nextLine();												//indexOf()应用
		 * if(!(email.indexOf("@")<0)&&!(email.indexOf
		 * (".")<0)&&(email.indexOf("@"))<(email.indexOf("."))){
		 * System.out.println("可以发送文件！"); }else{ System.out.println("邮箱无效！"); }
		 */
	/*	Scanner input=new Scanner(System.in);
		System.out.print("请输入字符串：");
		String a=input.nextLine();
		System.out.print("请输入要查找的字符:");
		String b=input.nextLine();
		String c[]=a.split(b);
		System.out.println(b+"在字符串中出现的次数为："+(c.length-1));
		*/
	/*	StringBuilder a=new StringBuilder();
		a.append("aaa");
		a.append("bbb");						//StringBuffer和StringBuilder
		a.append("ccc");
		System.out.println(a);
		String b=a.toString();
		System.out.println(b);*/
		
		/*int a=5;
		double b=1.5;
		b=a;*/
		/*int a;
		String b="123";
		String c="1234";
		int aa=new Integer(c);
		System.out.println(aa);
		a=Integer.parseInt(b);                //String转int Integer.parseInt()
		System.out.println(a);
		a=Integer.parseInt(c, 16);
		
		System.out.println(a);
		a=Integer.valueOf("12345");
		System.out.println(a);*/
		/*int a=(int) (Math.random()*100);    //随机数
		System.out.println(a);
		Random b=new Random();
		System.out.print(b.nextInt(2));*/
		/*StringBuffer a = new StringBuffer(); 
		StringBuffer b = null;                     //Sting初始化的初值
		System.out.println(a);		
		System.out.println(b);	*/	
		
		/*Hlg_Java1 a=new Hlg_Java1();
		System.out.println(a.letter(4));*/			//随机验证码
		/*String a=MessageFormat.format("select from Student where stuNo={0} and password={1}", 1234,123456);
		System.out.println(a);                         //MessageFormat.format()   格式化拼装
*/		
	/*	StringBuilder a=new StringBuilder();
		a.append("1");
		a.append(true);
		a.append(2.33);
		a.append(123);
		System.out.println(a);
		String b="";
		c=new String("as");
		System.out.println(c);*/
		/*ArrayList a = new ArrayList();
		a.add("aaa");
		a.add("bbb");                                 //ArrayList 遍历
		a.add("ccc");
		a.add(123);
		for(Object b:a){
		System.out.println((String)b);
	
		}*/
		
	/*	ArrayList a = new ArrayList();
		int y=1;
		int sum = 0;
		for(int i=0;i<10;i++){
			a.add(y);
			y++;
		}
		
		for(Object b:a){
			System.out.println(b);
		}
		for(int i=0;i<a.size();i++){                               //集合中添加1到10并计算和
			sum=(Integer)a.get(i)+sum;
		}
		System.out.println(MessageFormat.format("sum={0}",sum));
		*/
	/*	ArrayList a = new ArrayList();
		a.add("aaa");
		a.add("bbb");
		a.add("ccc");
		a.add("ddd");
		String [] b = a.toArray(String []);           //ArrayList转换成数组 ?
*/		
		
	/*	HashMap a=new HashMap();
		a.put("hu", "15757179540");
		a.put("li", "1234567890");                    //HashMap 存取
		
		System.out.println(a.keySet());
		System.out.println(a.get("hu"));						//Map遍历
		for(Object b:a.keySet()){
			System.out.println("Key="+b+"   Value="+a.get(b));
		}*/
		
		/*String a[] = new String []{new String("a")};
		Integer b = 3;
		b.toString();
		Student c = new Student(1,"a",15);               
		Student d = new Student(); 
		System.out.println(c.toString());
		System.out.println(d.toString());*/
		/*Student a[]=new Student[]{new Student(1,"a",20),new Student(2,"b",18),new Student(3,"c",21)};
		Student b = Cals1.max(a);
		System.out.println(b.toString());
		Student c = Cals1.min(a);
		System.out.println(c.toString());                                //泛型应用
		*/
		/*int b = 0;
		Pair a = new Pair();
		Pair c = new Pair(3);
		System.out.println(a.getA());					//可以访问接口定义的常量
		System.out.println(c.getA());					//实现接口Pair1  不会实现子接口Pair11的方法
		Student d= new Student();						//接口中定义的变量会自行生成为类常量，默认加上final 和 static
		System.out.println(Pair1.O);                     
		System.out.println(Student.stuA);*/
	/*	Student a = new Student();
		System.out.println(a.stuA);
		System.out.println(a.stuB);*/
		
													  
		
		
		
		
		
	}
	//随机验证码     
	String letter(int length){
		String letterChar="1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer a = new StringBuffer(); 
		Random b=new Random();
		for(int i=0;i<length;i++){
			a.append(letterChar.charAt(b.nextInt(letterChar.length())));
		}
		return a.toString();
		
	}



}
