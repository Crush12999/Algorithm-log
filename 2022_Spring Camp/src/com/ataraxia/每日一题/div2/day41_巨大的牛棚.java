package com.ataraxia.每日一题.div2;

import java.util.Scanner;

/**
 * @author Ataraxia
 * @create 2022/4/7 22:43
 * @description mle
 */
public class day41_巨大的牛棚 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] dp = new int[1010][1010];
        int n = sc.nextInt();
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            dp[x][y] = -1;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1], dp[i - 1][j]) + 1);
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(dp[i][j], ans);
            }
        }
        System.out.println(ans);
    }
}
