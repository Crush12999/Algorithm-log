package com.ming.luogu.sheet.ch01_入门.c6_函数与结构体;

import java.util.ArrayList;
import java.util.Scanner;

public class P5737_闰年展示 {
	
	static ArrayList<Integer> arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		arr = new ArrayList<>();
		int l = sc.nextInt();
		int r = sc.nextInt();
		int ans = 0;
		for (int i = l; i <= r; i++) {
			ans += isLeapYear(i);
		}
		System.out.println(ans);
		arr.forEach(item -> {
			System.out.print(item + " ");
		});
		
		sc.close();
	}
	
	public static int isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			arr.add(year);
			return 1;
		}
		return 0;
	}

}
