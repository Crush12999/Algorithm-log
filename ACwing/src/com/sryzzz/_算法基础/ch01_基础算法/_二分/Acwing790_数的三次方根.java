package com.sryzzz._算法基础.ch01_基础算法._二分;

import java.util.Scanner;

/**
 * @author sryzzz
 * @create 2022/7/14 22:49
 * @description https://www.acwing.com/problem/content/792/
 */
public class Acwing790_数的三次方根 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double l = -10000, r = 10000, mid;
        while (r - l > 1e-8) {
            mid = (l + r) / 2;
            if (mid * mid * mid >= n) {
                r = mid;
            } else {
                l = mid;
            }
        }
        System.out.printf("%.6f", l);
    }
}
