package com.ming.luogu.sheet.ch01_入门.c6_函数与结构体;

import java.util.Scanner;

public class P5744_培训 {

	static class Stu {
		String name;
		int age;
		int score;
		public Stu(String name, int age, int score) {
			this.name = name;
			this.age = age;
			this.score = score;
		}
		@Override
		public String toString() {
			return name + " " + age + " " + score;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String[] s = sc.nextLine().split(" ");
			String name = s[0];
			int age = Integer.parseInt(s[1]);
			int score = Integer.parseInt(s[2]);
			if (score * 0.2 + score <= 600) {
				score += score * 0.2;
			} else {
				score = 600;
			}
			System.out.println(new Stu(name, age + 1, score));
		}
		
		sc.close();
	}
}

