package com.sryzzz._算法基础.ch01_基础算法._前缀和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/7/15 22:54
 * @description https://www.acwing.com/problem/content/797/
 */
public class Acwing795_前缀和 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[] arr = new int[n + 1];
        int[] s = new int[n + 1];
        s[0] = 0;
        in.nextToken();
        int m = (int) in.nval;
        for (int i = 1; i < arr.length; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
            s[i] += arr[i] + s[i - 1];
        }
        while (m-- > 0) {
            in.nextToken();
            int l = (int) in.nval;
            in.nextToken();
            int r = (int) in.nval;
            System.out.println(s[r] - s[l - 1]);
        }
    }
}
