package com.ming.luogu.sheet.ch02_基础算法.c2_排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author ming
 * @create 2021-11-30
 * @description
 */
public class P1271_选举学生会 {

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int[] a = new int[1010];
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int tmp;
        for (int i = 0; i < m; i++) {
            in.nextToken();
            tmp = (int) in.nval;
            a[tmp]++;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < a[i]; j++) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
