package com.ataraxia._2021省赛JavaB_第一场;

import java.util.Scanner;

/**
 * @author Ataraxia
 * @create 2022/4/6 12:08
 * @description 双向排序
 */
public class _I_双向排序 {

    static int N = 100010;
    static int n, m;
    static Node[] stk = new Node[N];
    static int[] ans = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int top = 0;//栈顶

        while (m-- > 0) {

            int p = sc.nextInt();
            int q = sc.nextInt();

            if (p == 0) {
                //求出连续操作的最长前缀
                while (top != 0 && stk[top].x == 0) q = Math.max(q, stk[top--].y);
                //优化三
                while (top >= 2 && stk[top - 1].y <= q) top -= 2;
                stk[++top] = new Node(0, q);
            } else if (top != 0) {
                //求出连续操作的最长后缀
                while (top != 0 && stk[top].x == 1) q = Math.min(q, stk[top--].y);
                //优化三
                while (top >= 2 && stk[top - 1].y >= q) top -= 2;
                stk[++top] = new Node(1, q);
            }
        }

        //k是递减变量，l为左边界，r为右边界
        int k = n, l = 1, r = n;
        for (int i = 1; i <= top; i++) {
            if (stk[i].x == 0) {
                //若为前缀操作，则(stk[i].y, r]不用操作，直接填数
                while (r > stk[i].y && l <= r) ans[r--] = k--;
            } else {
                //若为后缀操作，则[l, stk[i].y)不用操作，直接填数
                while (l < stk[i].y && l <= r) ans[l++] = k--;
            }
            if (l > r) break;
        }

        //若l < r, 表示中间还有些数没有填上，操作次数为奇数，则下一次操作为前缀操作
        if (top % 2 == 1) {
            while (l <= r) ans[l++] = k--;
        } else {
            while (l <= r) ans[r--] = k--;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
