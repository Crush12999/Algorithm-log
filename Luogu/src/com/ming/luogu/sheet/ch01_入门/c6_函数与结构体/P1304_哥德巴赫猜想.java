package com.ming.luogu.sheet.ch01_入门.c6_函数与结构体;

import java.util.Arrays;
import java.util.Scanner;

public class P1304_哥德巴赫猜想 {

	// primes[x] 存储x是否是质数
	static boolean[] primes;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		primes = new boolean[10001];
		Arrays.fill(primes, true);
		
		// 获取素数表
		getPrime(n);
		
		
		for (int i = 4; i <= n; i += 2) {
			for (int j = 2; j < i; j++) {
//				if (isPrime(j) && isPrime(i - j)) {
//					System.out.println(i + "=" + j + "+" + (i-j));
//					break;
//				}
				if (primes[j] && primes[i - j]) {
					System.out.println(i + "=" + j + "+" + (i-j));
					break;
				}
			}
			
		}
		sc.close();
		
	}
	
	public static boolean isPrime(int x) {
		if (x < 2) {
			return false;
		}
		
		for (int i = 2; i <= x / i; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// 获取2 ~ x 范围内所有素数，存到primes[]里
	public static void getPrime(int x) {
		for (int i = 2; i <= x; i++) {
			if (primes[i]) {
				for (int j = 2; i * j <= x; j++) {
					primes[i * j] = false;
				}
			}
		}
	}
}
