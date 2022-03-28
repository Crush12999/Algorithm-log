package com.ataraxia.memory;

import java.util.Scanner;

/**
 * @author Ataraxia
 * @create 2022/3/28 12:12
 * @description 石子合并
 */
public class _石子合并_记忆化搜索 {

    static int[] a = new int[510];
    static int[] s = new int[510];
    static int[][] f = new int[510][510];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = -1;
            }
        }
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            s[i] = s[i - 1] + a[i];
        }
        System.out.println(solve(1, n));
    }

    public static int solve(int l, int r) {
        if (f[l][r] != -1) {
            return f[l][r];
        }
        // 如果只有一堆石子，不需要合并，代价为0
        if (l == r) {
            return 0;
        }
        int ans = 1 << 30;
        for (int k = l; k < r; k++) {
            ans = Math.min(ans, solve(l, k) + solve(k + 1, r));
        }
        return f[l][r] = ans + s[r] - s[l - 1];
    }
}
