package com.ming.luogu.sheet.ch02_基础算法.c1_模拟与高精度;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1042_乒乓球 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		// StreamTokenizer构造器的注释符、注释符后面的都不会被解析
		in.commentChar('E');
		StringBuilder sb = new StringBuilder("");
        // 逐行读取并添加到可变字符串上
		while(in.nextToken() != StreamTokenizer.TT_EOF) {
			String s1 = in.sval;
			sb.append(s1);
		}

		char[] list = sb.toString().toCharArray();
		int[] f = new int[] {11, 21};
		
		for (int i = 0; i < 2; i++) {
			int win = 0, lose = 0;
			for (int j = 0; j < list.length; j++) {
				win += (list[j] == 'W') ? 1 : 0;
				lose += (list[j] == 'L') ? 1 : 0;
				
				// 只有当先到11分的并且比分领先大于等于2的、才算胜利
				if (Math.max(win, lose) >= f[i] && Math.abs(win - lose) >= 2) {
					System.out.println(win + ":" + lose);
					win = lose = 0;
				}
			}
			// 正在进行中的比赛
			System.out.println(win + ":" + lose);
			System.out.println();
		}
		
	}
}
