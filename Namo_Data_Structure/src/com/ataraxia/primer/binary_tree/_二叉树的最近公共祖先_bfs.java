package com.ataraxia.primer.binary_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 二叉树的最近公共祖先_bfs写法
 *
 * @author sryzzz
 * @create 2022/8/20 22:37
 * @description http://oj.daimayuan.top/course/7/problem/457
 */
public class _二叉树的最近公共祖先_bfs {

    private static class Node {
        int depth;
        int left, right, fa;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        Node[] a = new Node[n + 1];
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

        int[] q = new int[n + 1];
        int front = 1, rear = 1;
        q[1] = 1;
        a[1].depth = 1;
        while (front <= rear) {
            int p = q[front];
            ++front;
            if (a[p].left > 0) {
                q[++rear] = a[p].left;
                a[a[p].left].depth = a[p].depth + 1;
            }
            if (a[p].right > 0) {
                q[++rear] = a[p].right;
                a[a[p].right].depth = a[p].depth + 1;
            }
        }
        in.nextToken();
        int u = (int) in.nval;
        in.nextToken();
        int v = (int) in.nval;
        if (a[u].depth < a[v].depth) {
            int t = u;
            u = v;
            v = t;
        }
        int x = a[u].depth - a[v].depth;
        for (int i = 1; i <= x; i++) {
            u = a[u].fa;
        }
        while (u != v) {
            u = a[u].fa;
            v = a[v].fa;
        }
        System.out.println(u);
    }
}
