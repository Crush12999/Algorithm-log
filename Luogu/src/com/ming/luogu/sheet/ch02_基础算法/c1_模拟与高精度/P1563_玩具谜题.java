package com.ming.luogu.sheet.ch02_基础算法.c1_模拟与高精度;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 
 * 必须使用快读优化
 * 思路：模拟环形数组，在逆时针循环时必须注意需要加上一个n再模n，否则会减成负数
 * 关键指针位置修改式：
 * 		q = (q + 需要顺时针移动的次数) % n;
 * 		q = (q - 需要逆时针移动的次数 + n) % n;
 * @author Aqua99
 *
 */

public class P1563_玩具谜题 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int) in.nval;
		in.nextToken();
		int m = (int) in.nval;
		
		Man[] mans = new Man[n];
		
		for (int i = n - 1; i >= 0; i--) {
			Man man = new Man();
			in.nextToken();
			man.dir = (int) in.nval;
			in.nextToken();
			man.name = in.sval;
			mans[i] = man;
		}
		int q = n - 1;
		for (int i = 0, dis = 0, no = 0; i < m; i++) {
			in.nextToken();
			dis = (int) in.nval;
			in.nextToken();
			no = (int) in.nval;
			if (mans[q].dir == 0) {
				q = (dis == 0) ? (q + no) % n : (q - no + n) % n;
			} else {
				q = (dis == 0) ? (q - no + n) % n : (q + no) % n;
			}
			
		}
		
		System.out.println(mans[q].name);

	}

}
class Man {
	int dir;
	String name;
	public Man() {}
	public Man(int dir, String name) {
		this.dir = dir;
		this.name = name;
	}
}
