package com.ming.luogu.sheet.ch01_入门.c6_函数与结构体;

import java.util.Scanner;

public class P5739_计算阶乘 {

	static long ans = 1;
	static long n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		factorial(n);
		System.out.println(ans);
		
		sc.close();
	}
	
	public static void factorial(long x) {
		if (x == 0) {
			return;
		}
		ans *= x;
		factorial(x-1);
	}
	
}
