package com.ming.luogu.sheet.ch02_基础算法.c5_贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author ming
 * @create 2021-12-16
 * @description
 */
public class P2240_部分背包问题 {
    static class Coin {
        int m, v;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, t, c, i;
        double ans = 0;
        n = sc.nextInt();
        t = sc.nextInt();
        c = t;
        Coin[] coins = new Coin[n];
        for (i = 0; i < n; i++) {
            coins[i] = new Coin();
            coins[i].m = sc.nextInt();
            coins[i].v = sc.nextInt();
        }
        Arrays.sort(coins, new Comparator<Coin>() {
            @Override
            public int compare(Coin x, Coin y) {
                return y.v * x.m - x.v * y.m;
            }
        });

        for (i = 0; i < n; i++) {
            if (coins[i].m > c) {
                break;
            }
            c -= coins[i].m;
            ans += coins[i].v;
        }
        if (i < n) {
            ans += 1.0 * c / coins[i].m * coins[i].v;
        }
        System.out.printf("%.2f", ans);
        sc.close();
    }
}
