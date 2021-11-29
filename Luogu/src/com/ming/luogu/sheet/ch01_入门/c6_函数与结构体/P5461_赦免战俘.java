package com.ming.luogu.sheet.ch01_入门.c6_函数与结构体;

import java.util.Scanner;

/**
 * @author ming
 * @create 2021-11-29
 * @description 赦免战俘
 * @idea 内存超限。。。MLE了
 */
public class P5461_赦免战俘 {

    static int n;
    static int[][] mp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        mp = new int[1050][1050];
        cal(0, 0, n);
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < 1 << n; j++) {
                System.out.printf("%d%c", mp[i][j], j == (1 << n) - 1 ? '\n' : ' ');
            }
        }
    }

    public static void cal(int x, int y, int n) {
        if (n == 0) {
            mp[x][y] = 1;
        } else {
            cal(x + (1 << n - 1), y, n - 1); // 右上方矩阵
            cal(x, y + (1 << n - 1), n - 1); // 左下方矩阵
            cal(x + (1 << n - 1), y + (1 << n - 1), n - 1); // 右下方矩阵
        }
    }
}
