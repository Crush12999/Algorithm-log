package com.ming.luogu.sheet.ch02_基础算法.c2_排序;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author ming
 * @create 2021-12-10
 * @description
 */
public class P1781_宇宙总统 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger max = new BigInteger("0");
        BigInteger m;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            m = sc.nextBigInteger();
            if (max.compareTo(m) < 0) {
                max = m;
                index = i;
            }
        }
        System.out.println(index);
        System.out.println(max);

        sc.close();

    }
}
