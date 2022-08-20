package com.ataraxia.primer.binary_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 二叉树的最近公共祖先
 *
 * @author sryzzz
 * @create 2022/8/20 22:21
 * @description http://oj.daimayuan.top/course/7/problem/457
 */
public class _二叉树的最近公共祖先 {

    private static class Node {
        int fa;
        int left, right;
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
        in.nextToken();
        int u = (int) in.nval;
        in.nextToken();
        int v = (int) in.nval;
        // u 到根节点的路径
        int[] c = new int[n + 1];
        // v 到根节点的路径
        int[] d = new int[n + 1];
        // u 到根的路径有多少个点
        int l1 = 0;
        while (u != 1) {
            c[++l1] = u;
            u = a[u].fa;
        }
        c[++l1] = 1;
        int l2 = 0;
        while (v != 1) {
            d[++l2] = v;
            v = a[v].fa;
        }
        d[++l2] = 1;

        // 公共后缀
        int x = 0;
        // 从最后开始往前看
        for (int i = l1, j = l2; i > 0 && j > 0; i--, j--) {
            if (c[i] == d[j]) {
                x = c[i];
            } else {
                break;
            }
        }
        System.out.println(x);
    }
}
