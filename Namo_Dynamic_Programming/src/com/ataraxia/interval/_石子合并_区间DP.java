package com.ataraxia.interval;

import java.util.Scanner;

/**
 * @author Ataraxia
 * @create 2022/3/28 11:15
 * @description 石子合并
 */
public class _石子合并_区间DP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[510];
        int[] a = new int[510];
        int[][] f = new int[510][510];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            s[i] = s[i - 1] + a[i];
            f[i][i] = 0;
        }

        // 阶段：枚举区间长度，最小从2堆开始合并
        for (int i = 2; i <= n; i++) {
            // 状态：枚举区间起点，起点位置加上区间长度不大于总长度
            for (int l = 1; l + i - 1 <= n; l++) {
                int r = l + i - 1;
                // 决策：枚举分界线
                for (int k = l; k < r; k++) {
                    f[l][r] = Math.min(f[l][r], f[l][k] + f[k + 1][r] + s[r] - s[l - 1]);
                }
            }
        }

        System.out.println(f[1][n]);

        sc.close();
    }
}
