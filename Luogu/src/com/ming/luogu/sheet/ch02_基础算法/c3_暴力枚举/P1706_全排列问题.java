package com.ming.luogu.sheet.ch02_基础算法.c3_暴力枚举;

import java.util.Scanner;

/**
 * @author ming
 * @create 2021-12-02
 * @description MLE内存超限
 */
public class P1706_全排列问题 {

    static int n;
    static int[] ans = new int[10];
    static boolean[] boo = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
        sc.close();
    }

    public static void dfs(int x) {
        if (x == n) {
            for (int i = 0; i < n; i++) {
                System.out.printf("%5d", ans[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!boo[i]) {
                ans[x] = i;
                boo[i] = true;
                dfs(x + 1);
                boo[i] = false;
            }
        }
    }
}
