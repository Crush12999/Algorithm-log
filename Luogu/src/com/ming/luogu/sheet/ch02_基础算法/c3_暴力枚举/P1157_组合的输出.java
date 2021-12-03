package com.ming.luogu.sheet.ch02_基础算法.c3_暴力枚举;

import java.util.Scanner;

/**
 * @author ming
 * @create 2021-12-03
 * @description
 * 从全局枚举到0，从高位到低位分别表示元素1 到 n，就可以让1尽量出现在靠前的位置，
 * 从而符合字典序要求
 */
public class P1157_组合的输出 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[30];
        int n = sc.nextInt();
        int r = sc.nextInt();

        // 从全集枚举到0
        for (int S = (1 << n) - 1; S >= 0; S--) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if ((S & (1 << i)) != 0) {
                    // 分离记录每一位
                    a[cnt++] = i;
                }
            }
            if (cnt == r) {
                for (int i = r - 1; i >= 0; i--) {
                    System.out.printf("%3d", n - a[i]);
                }
                System.out.println();
            }
        }

        sc.close();
    }

}
