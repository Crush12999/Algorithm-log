package com.ming.luogu.sheet.ch01_入门.c6_函数与结构体;

import java.util.Scanner;

public class P2415_集合求和 {

	// 推导：输入元素和*2^(n-1)
	// [] [2] [3] [2 3] 2+3+2+3 = 10 => (2+3)*2^(2-1)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[30];
		
		long sum = 0;
		int i = 0;
		
		while (sc.hasNext()) {
			a[i] = sc.nextInt();
			sum += a[i];
			i++;
		}
		
		long ans = (long)(Math.pow(2.0, i - 1) * sum);
		
		System.out.println(ans);
			
		sc.close();
	}
}
