package com.ataraxia.interval;

import java.util.Scanner;

/**
 * @author Ataraxia
 * @create 2022/3/28 12:23
 * @description 环形石子合并
 */
public class _环形石子合并_区间DP {

    static int N = 1002;
    static int[] a = new int[N];
    static int[] s = new int[N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= 2 * n; i++) {
            for (int j = 1; j <= 2 * n; j++) {
                f[i][j] = 1 << 30;
            }
        }

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            // 复制一遍区间
            a[i + n] = a[i];
        }

        for (int i = 1; i <= 2 * n; i++) {
            s[i] = s[i - 1] + a[i];
            f[i][i] = 0;
        }

        for (int len = 2; len <= n; len++) {
            for (int l = 1; l + len - 1 <= 2 * n; l++) {
                int r = l + len - 1;
                for (int k = l; k < r; k++) {
                    f[l][r] = Math.min(f[l][r], f[l][k] + f[k + 1][r] + s[r] - s[l - 1]);
                }
            }
        }
        // 目标输出
        int minN = 1 << 30;
        for (int i = 1; i <= n; i++) {
            minN = Math.min(minN, f[i][i + n - 1]);
        }
        System.out.println(minN);
        sc.close();
    }

}
