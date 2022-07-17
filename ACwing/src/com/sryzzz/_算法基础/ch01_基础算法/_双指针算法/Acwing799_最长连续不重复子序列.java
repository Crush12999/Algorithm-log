package com.sryzzz._算法基础.ch01_基础算法._双指针算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/7/17 23:40
 * @description https://www.acwing.com/problem/content/801/
 */
public class Acwing799_最长连续不重复子序列 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[] a = new int[100005];
        int[] s = new int[100005];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            s[a[i]]++;
            while (s[a[i]] > 1) {
                s[a[j]]--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        System.out.println(res);
    }
}
