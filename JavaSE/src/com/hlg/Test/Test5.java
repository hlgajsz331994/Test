package com.hlg.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//java��ô�ڿ���̨����һ������Ȼ��س�������һ������n�� ���ͳһ���������̨��
public class Test5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int time =5;
		for(int i=0;i<time;i++){
			sb.append(br.readLine()+"\n");
		}
		System.out.println(sb.toString());
	}
}
