package com.ming.luogu.sheet.ch02_基础算法.c2_排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author ming
 * @create 2021-12-01
 * @description
 */
public class P1059_明明的随机数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] a = new Integer[n];
        int[] ans = new int[n];
        int cnt = 0, tmp = -1;

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        for (int i = 0; i < n; i++) {
            if (a[i] != tmp) {
                ans[cnt++] = a[i]; // 当前的和上一个不同才复制到新数组
            }
            tmp = a[i];
        }

        System.out.println(cnt);

        for (int i = 0; i < cnt; i++) {
            System.out.print(ans[i] + " ");
        }

        sc.close();
    }
}
