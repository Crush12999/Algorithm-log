package com.ataraxia._2021省赛JavaB_第一场;

/**
 * @author Ataraxia
 * @create 2022/4/6 11:16
 * @description 货物摆放
 */
public class _D_货物摆放 {

    static long n = 2021041820210418L;
    static long[] num = new long[10000];
    static int a = 0;

    public static void main(String[] args) {
        int ans = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                for (int j = i; j <= Math.sqrt(n / i); j++) {
                    if (n / i % j == 0) {
                        if (i == j && j == n / i / j) {
                            ans++;
                        } else if (i == j || j == n / i / j || i == n / i / j) {
                            ans += 3;
                        } else {
                            ans += 6;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

}
