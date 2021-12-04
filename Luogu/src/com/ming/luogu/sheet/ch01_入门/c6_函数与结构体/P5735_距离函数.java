package com.ming.luogu.sheet.ch01_入门.c6_函数与结构体;

//import java.text.DecimalFormat;
import java.util.Scanner;

public class P5735_距离函数 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 格式化输出
//		DecimalFormat df = new DecimalFormat("0.00");
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();
		double x3 = sc.nextDouble();
		double y3 = sc.nextDouble();
		
		double dis = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)) + 
				Math.sqrt((x3-x1)*(x3-x1) + (y3-y1)*(y3-y1)) + 
				Math.sqrt((x2-x3)*(x2-x3) + (y2-y3)*(y2-y3));
//		System.out.println(df.format(dis));
		System.out.printf("%.2f", dis);
		
		sc.close();
		
	}
}
