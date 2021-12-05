package com.ming.luogu.sheet.ch01_入门.c6_函数与结构体;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P5736_质数筛 {

	static boolean[] primes;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		primes = new boolean[100002];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		getPrimes(100001);
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			int q = sc.nextInt();
			if (primes[q]) {
				list.add(q);
			}
		}
		
		list.forEach(item -> {
			System.out.print(item + " ");
		});
		
		sc.close();
	}
	
	public static void getPrimes(int n) {
		for (int i = 2; i <= n; i++) {
			if (primes[i]) {
				for (int j = 2; i * j <= n; j++) {
					primes[i * j] = false;
				}
			}
		}
	}
}
