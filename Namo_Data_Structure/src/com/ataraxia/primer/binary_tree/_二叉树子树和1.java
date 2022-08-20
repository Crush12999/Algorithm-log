package com.ataraxia.primer.binary_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 二叉树子树和1 - dfs
 *
 * @author sryzzz
 * @create 2022/8/20 22:49
 * @description http://oj.daimayuan.top/course/7/problem/458
 */
public class _二叉树子树和1 {

    private static class Node {
        // 权值
        int w;
        int left, right, fa;
    }

    private static int cnt;
    private static Node[] a;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        a = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new Node();
        }
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            int x = (int) in.nval;
            in.nextToken();
            int y = (int) in.nval;
            if (x > 0) {
                a[i].left = x;
                a[x].fa = i;
            }
            if (y > 0) {
                a[i].right = y;
                a[y].fa = i;
            }
        }
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            a[i].w = (int) in.nval;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            cnt = 0;
            order(i);
            sb.append(cnt).append(" ");
        }
        System.out.println(sb);
    }

    private static void order(int t) {
        cnt += a[t].w;
        if (a[t].left > 0) {
            order(a[t].left);
        }
        if (a[t].right > 0) {
            order(a[t].right);
        }
    }
}
