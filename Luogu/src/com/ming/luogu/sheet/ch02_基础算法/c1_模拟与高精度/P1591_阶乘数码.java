package com.ming.luogu.sheet.ch02_基础算法.c1_模拟与高精度;


import java.math.BigInteger;
import java.util.Scanner;

public class P1591_阶乘数码 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while (t-- > 0) {
			String[] strs = sc.nextLine().split(" ");
			getNum(strs);
			
		}
		
		sc.close();
	}
	
	public static void getNum(String[] strs) {
		
		int ans = 0;
		BigInteger bigInteger = new BigInteger("1");
		BigInteger num = new BigInteger("1");
		
		for (int i = 0; i < Integer.valueOf(strs[0]); i++) {
			bigInteger = bigInteger.multiply(num);
			num = num.add(new BigInteger("1"));
		}

		String s = bigInteger.toString();
		int index = -1;
		while (s.indexOf(strs[1], index + 1) != -1) {
			index = s.indexOf(strs[1], index + 1);
			ans++;
		}
		
		System.out.println(ans);
	}

}
