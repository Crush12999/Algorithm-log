package com.ataraxia._2021省赛JavaB_第一场;

import java.util.Scanner;

/**
 * @author Ataraxia
 * @create 2022/4/6 12:06
 * @description 时间显示
 */
public class _F_时间显示 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        long n = Long.parseLong(str);
        n /= 1000;
        long tBase = 60 * 60 * 24;
        n %= tBase;
        long h, m, s;
        h = n / 60 / 60;
        n -= h * 60 * 60;
        m = n / 60;
        n -= m * 60;
        s = n;
        System.out.printf("%02d:%02d:%02d\n", h, m, s);
    }
}
