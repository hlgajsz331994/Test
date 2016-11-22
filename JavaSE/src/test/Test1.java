package test;

import java.util.Date;


class BirthDate {  
	    private int day;  
	    private int month;  
	    private int year;      
	    public BirthDate(int d, int m, int y) {  
	        day = d;   
	        month = m;   
	        year = y;  
	    }
	    public void BirthDatee(){
	    	System.out.println(day+month+year);
	    }
	}  
	  
	public class Test1{  
	    public static void main(String args[]){  
	    	String date=new String("abc");  
	    	String a2="abc";
	    	String a1=new String("abc");
	    	System.out.println(a1==a2);
	    	String a3=a1.intern();
	    	System.out.println(a3==a2);
	    	a1="cba";
	    	a2="cba";
	    	System.out.println(a1==a2);
	    	a2=a1;
//	    	System.out.println(a1==a2);
	    	System.out.println(a2);
	    	a2="cba";
	    	System.out.println(a1);
	        Test1 test = new Test1();        
//	        test.change1(date);   
	        BirthDate d1= new BirthDate(7,7,1970);
//	        System.out.println(date);
	        System.out.println(new Date());
	        d1.BirthDatee();
	        a1.intern();
	        
	    }    
	
	    public void change1(String i){  
	    	System.out.println(i);
	    	i="cba";
	    	
	    }
	    
	}
	