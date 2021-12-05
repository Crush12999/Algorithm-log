package com.ming.luogu.sheet.ch01_入门.c6_函数与结构体;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Scanner;

public class P5738_歌唱比赛 {

	public static void main(String[] args) throws Exception {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		Scanner sc = new Scanner(System.in);
		int n = (int) in.nval;
		in.nextToken();
		int m = (int) in.nval;
		double[] score = new double[m];
		double ans = 0.0;
		for (int i = 0; i < n; i++) {
			double maxN = 0.0;
			for (int j = 0; j < m; j++) {
				in.nextToken();
				score[j] = in.nval;
			}
			Arrays.sort(score);
			// 源数组、源数组复制的起始位置、目的数组、目的数组放置的起始位置、复制的长度
			// System.arraycopy(score, 1, pre, 0, m - 1);
			for (int j = 1; j < score.length - 1; j++) {
				maxN += score[j];
			}
			maxN /= (m - 2);
			ans = ans > maxN ? ans : maxN;
		}
		
		System.out.printf("%.2f", ans);
		
		sc.close();
	}
}


