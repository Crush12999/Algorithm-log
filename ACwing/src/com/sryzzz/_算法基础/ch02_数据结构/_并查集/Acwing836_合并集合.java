package com.sryzzz._算法基础.ch02_数据结构._并查集;

import java.util.Scanner;

/**
 * @author sryzzz
 * @create 2022/8/14 23:47
 * @description https://www.acwing.com/problem/content/838/
 */
public class Acwing836_合并集合 {

    static int N = 100010;
    static int[] pa = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        init(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            String op = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if ("M".equals(op)) {
                union(a, b);
            } else {
                String flag = (find(a) == find(b)) ? "Yes\n" : "No\n";
                sb.append(flag);
            }
        }
        System.out.print(sb);
    }
    public static void init(int n) {
        for (int i = 1; i <= n; i++) {
            pa[i] = i;
        }
    }

    public static int find(int x) {
        if (pa[x] != x) {
            pa[x] = find(pa[x]);
        }
        return pa[x];
    }

    public static void union(int x, int y) {
        pa[find(y)] = find(x);
    }
}
