package com.hlg.Test;

import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner;  
  //Scanner    nextInt()��������ȡ���з�
public class NextIntTest {  
  
    public static void main(String[] args) {  
          
        Scanner sc = new Scanner(System.in);  
        List<Student> students = new ArrayList<Student>() ;  
  
        for(int i = 0 ; i < 3; i++){  
            Student s = new Student();  
            System.out.print("Enter name:");  
            s.name = sc.nextLine();  
            System.out.print("Enter number:");  
            s.number = sc.nextInt();  
            students.add(s);              
        }  
        for(Student s : students){  
            System.out.println(s.name+" : " + s.number);  
        }  
    }  
}  
  
  
class Student{  
    //ѧ������  
    String name;  
    //ѧ��  
    int number;  
}  
