package com.ataraxia._2021省赛JavaB_第一场;

import java.util.Scanner;

/**
 * @author Ataraxia
 * @create 2022/4/6 12:07
 * @description 杨辉三角形
 */
public class _H_杨辉三角形 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        for (int k = 16; ; k--) {
            if (check(k)) break;
        }
    }

    private static boolean check(int k) {
        long l = k * 2, r = n;
        while (l < r) {
            long mid = l + r >> 1;
            if (C(mid, k) >= n) r = mid;
            else l = mid + 1;
        }

        if (C(r, k) != n) return false;

        System.out.println(r * (r + 1) / 2 + k + 1);

        return true;
    }

    private static long C(long a, long b) {
        long res = 1;
        for (long i = a, j = 1; j <= b; i--, j++) {
            res = res * i / j;
            if (res > n) return res;
        }
        return res;
    }
}
