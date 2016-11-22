package com.hlg.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//java怎么在控制台输入一行内容然后回车在输入一行连续n次 最后统一输出到控制台？
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
