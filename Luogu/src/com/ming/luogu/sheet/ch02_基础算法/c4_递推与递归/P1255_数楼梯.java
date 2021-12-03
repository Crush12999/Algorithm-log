package com.ming.luogu.sheet.ch02_基础算法.c4_递推与递归;
import java.math.BigInteger;
import java.util.Scanner;
/**
 * @author ming
 * @create 2021-12-03
 * @description 要用大数存
 */
public class P1255_数楼梯 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
        } else {
            BigInteger[] f = new BigInteger[5010];
            f[1] = new BigInteger("1");
            f[2] = new BigInteger("2");
            for (int i = 3; i <= n; i++) {
                f[i] = f[i-2].add(f[i-1]);
            }
            System.out.println(f[n]);
        }
        sc.close();
    }
}
