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
		                                      //intern�÷�
	/*	String a="123";
		String b=new String("123");
		String c="123";
		String d = null;
		String e=new String("kvill");
		String f=new String("kvill");
		b.intern();
		System.out.println(a==b.intern());
		System.out.println(a==c);*/
		                                     //Scanner�÷�
		/*String name;
		double sum=0;
		Scanner input=new Scanner(System.in); 
		System.out.print("������ѧ��������");
		name=input.nextLine();
		while(true){
			for(int i=1;i<=5;i++){
				
				
				System.out.print("���������Ź��ε�"+i+"�ſεĳɼ���");
				int score;
				score=input.nextInt();
				sum=sum+score;
			}
			break;
		}
		System.out.println(name+"��ƽ�����ǣ�"+sum/5);
		*/
		
		                                       //Scanner��ϰ
		/*int i;
		int score;
		int geshu=0;
		double bili=0;
		Scanner input = new Scanner(System.in);
		System.out.print("����༶������:");
		i=input.nextInt();
		for(int j=0;j<i;j++){
			System.out.print("�������"+(j+1)+"λѧ���ĳɼ�: ");
			score=input.nextInt();
			if(score>=80){
				geshu++;
			}
		}
		System.out.println("80�����ϵ�ѧ��������:"+geshu);
		bili=(double)geshu/i;                                                  //int��תDouble
		System.out.println("80�����ϵ�ѧ����ռ�ı���Ϊ:"+bili*100+"%");
		*/
		
		/*System.out.print("����\t123");    //\t�൱������
*/		
		/*int i;
		System.out.println("*************************************************************");
		System.out.println("*                        1.��¼ϵͳ                                                                    *");
		System.out.println("*                                                           *");
		System.out.println("*                        2.�˳�                                                                              *");
		System.out.println("*************************************************************");
		System.out.println("��ѡ���������֣�");
		Scanner input = new Scanner(System.in);
		i=input.nextInt();*/
		
		/*double a=1.2;
		int b=(int)a;
		System.out.println(b);   //�����͸�С���͸�ֵ��Ҫת��
*/		
		/*int a=1;
		switch(a){
		case 1:
			break;
		case 2:
		case 3: 								//�ظ�Switch
		case 4:
			System.out.println(a);
			break;
		default:System.out.println(5);
		}*/
		
	/*	for(int i=0;i<=10;i++){
			if(i>5){
//				break;
				return;                     //break������ǰѭ����return��������������
			}
			System.out.println(i);
		}
		System.out.println("End");
		*/
		/*int[] nums={1,2,3,4,5,6};
		System.out.println("���鳤��Ϊ:"+nums.length);    //���鳤��
		*/
	/*	String a[]=new String[3];
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}*/
/*		Scanner input=new Scanner(System.in);
		System.out.print("��������λ��Ա�����ţ�");
		int card=input.nextInt();
		int khh=card/1000+card/100%10+card/10%10+card%10;
		System.out.println(card/1000);
		System.out.println(card/100%10);
		System.out.println(card/10%10);
		System.out.println(card%10);
		System.out.print("��Ա����"+card+"��λ֮��:"+khh);*/
/*		String a = "123";
		String b = "123";
		String c = new String("123");
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));*/
		/*
		 * Scanner input=new Scanner(System.in); System.out.print("�����������ʺţ�");
		 * String email=input.nextLine();												//indexOf()Ӧ��
		 * if(!(email.indexOf("@")<0)&&!(email.indexOf
		 * (".")<0)&&(email.indexOf("@"))<(email.indexOf("."))){
		 * System.out.println("���Է����ļ���"); }else{ System.out.println("������Ч��"); }
		 */
	/*	Scanner input=new Scanner(System.in);
		System.out.print("�������ַ�����");
		String a=input.nextLine();
		System.out.print("������Ҫ���ҵ��ַ�:");
		String b=input.nextLine();
		String c[]=a.split(b);
		System.out.println(b+"���ַ����г��ֵĴ���Ϊ��"+(c.length-1));
		*/
	/*	StringBuilder a=new StringBuilder();
		a.append("aaa");
		a.append("bbb");						//StringBuffer��StringBuilder
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
		a=Integer.parseInt(b);                //Stringתint Integer.parseInt()
		System.out.println(a);
		a=Integer.parseInt(c, 16);
		
		System.out.println(a);
		a=Integer.valueOf("12345");
		System.out.println(a);*/
		/*int a=(int) (Math.random()*100);    //�����
		System.out.println(a);
		Random b=new Random();
		System.out.print(b.nextInt(2));*/
		/*StringBuffer a = new StringBuffer(); 
		StringBuffer b = null;                     //Sting��ʼ���ĳ�ֵ
		System.out.println(a);		
		System.out.println(b);	*/	
		
		/*Hlg_Java1 a=new Hlg_Java1();
		System.out.println(a.letter(4));*/			//�����֤��
		/*String a=MessageFormat.format("select from Student where stuNo={0} and password={1}", 1234,123456);
		System.out.println(a);                         //MessageFormat.format()   ��ʽ��ƴװ
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
		a.add("bbb");                                 //ArrayList ����
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
		for(int i=0;i<a.size();i++){                               //���������1��10�������
			sum=(Integer)a.get(i)+sum;
		}
		System.out.println(MessageFormat.format("sum={0}",sum));
		*/
	/*	ArrayList a = new ArrayList();
		a.add("aaa");
		a.add("bbb");
		a.add("ccc");
		a.add("ddd");
		String [] b = a.toArray(String []);           //ArrayListת�������� ?
*/		
		
	/*	HashMap a=new HashMap();
		a.put("hu", "15757179540");
		a.put("li", "1234567890");                    //HashMap ��ȡ
		
		System.out.println(a.keySet());
		System.out.println(a.get("hu"));						//Map����
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
		System.out.println(c.toString());                                //����Ӧ��
		*/
		/*int b = 0;
		Pair a = new Pair();
		Pair c = new Pair(3);
		System.out.println(a.getA());					//���Է��ʽӿڶ���ĳ���
		System.out.println(c.getA());					//ʵ�ֽӿ�Pair1  ����ʵ���ӽӿ�Pair11�ķ���
		Student d= new Student();						//�ӿ��ж���ı�������������Ϊ�ೣ����Ĭ�ϼ���final �� static
		System.out.println(Pair1.O);                     
		System.out.println(Student.stuA);*/
	/*	Student a = new Student();
		System.out.println(a.stuA);
		System.out.println(a.stuB);*/
		
													  
		
		
		
		
		
	}
	//�����֤��     
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
