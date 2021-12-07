package com.ming.luogu.sheet.ch01_入门.c6_函数与结构体;

import java.util.Scanner;

public class P5743_猴子吃桃 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 1;
		for (int i = 2; i <= n; i++) {
			ans = (ans + 1) * 2;
		}
		System.out.println(ans);
		sc.close();
	}
}
