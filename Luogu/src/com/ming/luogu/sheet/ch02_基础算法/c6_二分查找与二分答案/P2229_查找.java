package com.ming.luogu.sheet.ch02_基础算法.c6_二分查找与二分答案;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author ming
 * @create 2021-12-13
 * @description
 */
public class P2229_查找 {

    static int n, m, q;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        arr = new int[n + 10];

        for (int i = 1; i <= n; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < m; i++) {
            in.nextToken();
            q = (int) in.nval;
            sb.append(find(q)).append(" ");
        }
        System.out.println(sb);
    }

    public static int find(int x) {
        int l = 1, r = n + 1;
        while (l < r) {
            // 中间页数
            int mid = l + ((r - l) >> 1);
            if (arr[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (arr[l] == x) {
            return l;
        }
        return -1;
    }

}
