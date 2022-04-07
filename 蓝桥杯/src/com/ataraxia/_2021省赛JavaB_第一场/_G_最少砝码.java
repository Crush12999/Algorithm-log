package com.ataraxia._2021省赛JavaB_第一场;

import java.util.Scanner;

/**
 * @author Ataraxia
 * @create 2022/4/6 12:06
 * @description 最少砝码
 * 每个砝码有三种状态，放左边（正数），放右边（负数），不放
 * 给定的N满足：3^0+3^1+3^2+......+3^k<N<3^0+3^1+3^2+......+3^k+3^(k+1)
 */
public class _G_最少砝码 {

    static long n, ans = 0, t = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        while (t < n) {
            t += Math.pow(3, ans);
            ans++;
        }
        System.out.println(ans);
    }
}
