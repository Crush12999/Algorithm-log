package com.ming.luogu.sheet.ch01_入门.c6_函数与结构体;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ming
 * @create 2021-11-28
 * @description 回文质数
 */
public class P1217_PrimePalindromes {

    static int N = 10000007;
    // 质数筛
    static int[] primes = new int[N];
    static int cnt = 0;
    // 是否筛过
    static boolean[] vis = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        b = Math.min(b, 10000000);

        getPrimes(b);

        for (int i = a; i <= b; i++) {
            if (judge(i) && !vis[i]) {
                System.out.println(i);
            }
        }

        sc.close();
    }

    // 线筛
    public static void getPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!vis[i]) {
                primes[cnt++] = i;
            }
            for (int j = 0; primes[j] <= n / i; j++) {
                vis[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
    }

    public static boolean judge(int x) {
        int y = x, t = 0;
        while (y > 0) {
            t = t * 10 + y % 10;
            y /= 10;
        }
        return t == x;
    }

}
