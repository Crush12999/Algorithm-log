package com.sryzzz._算法基础.ch01_基础算法._前缀和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/7/16 22:35
 * @description https://www.acwing.com/problem/content/798/
 */
public class Acwing796_子矩阵的和 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        int q = (int) in.nval;
        int[][] a = new int[n + 1][m + 1];
        int[][] s = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                in.nextToken();
                a[i][j] = (int) in.nval;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + a[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            in.nextToken();
            int x1 = (int) in.nval;
            in.nextToken();
            int y1 = (int) in.nval;
            in.nextToken();
            int x2 = (int) in.nval;
            in.nextToken();
            int y2 = (int) in.nval;
            sb.append(s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1]).append("\n");
        }
        System.out.print(sb);

    }
}
