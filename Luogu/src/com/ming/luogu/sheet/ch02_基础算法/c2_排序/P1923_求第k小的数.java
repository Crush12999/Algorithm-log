package com.ming.luogu.sheet.ch02_基础算法.c2_排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * Java必须用快读，Scanner必超时
 * @author Aqua99
 */

public class P1923_求第k小的数 {
	
	static int[] q;
	static int ans, key;

	static class InputReader {
	StreamTokenizer tokenizer;

	public InputReader(InputStream inputStream) {
		tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(inputStream)));
		tokenizer.ordinaryChars(33, 126);
		tokenizer.wordChars(33, 126);
	}

	public String next() throws IOException {
		tokenizer.nextToken();
		return tokenizer.sval;
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public boolean hasNext() throws IOException {
		int res = tokenizer.nextToken();
		tokenizer.pushBack();
		return res != StreamTokenizer.TT_EOF;
	}

}
	
	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		q = new int[n + 1];
		
		key = in.nextInt() + 1;
		
		for (int i = 1; i <= n; i++) {
			q[i] = in.nextInt();
		}
		
		findK(1, n);
		
		System.out.println(ans);
		
	}
	
	public static void findK(int l, int r) {
		if (l == r) {
			ans = q[l];
			return;
		}
		int i = l, j = r, base = q[(l+r) >> 1], temp;
		
		do {
			while (q[i] < base) i++;
			while (q[j] > base) j--;
			if (i <= j) {
				temp = q[i];
				q[i] = q[j];
				q[j] = temp;
				i++;
				j--;
			}
			
		} while(i <= j);
		
		
		if (key <= j) {
			findK(l, j);
		} else if (i <= key) {
			findK(i, r);
		} else {
			findK(j + 1, i - 1);
		}
		
	}

}


