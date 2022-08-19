package com.ataraxia.primer.binary_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 遍历一般二叉树
 *
 * @author sryzzz
 * @create 2022/8/19 23:02
 * @description http://oj.daimayuan.top/course/7/problem/431
 */
public class _遍历一般二叉树 {

    private static class Node {
        int fa;
        int left, right;
    }

    private static int n;
    private static StringBuilder sb;
    private static Node[] a;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        a = new Node[n + 1];
        sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            a[i] = new Node();
        }
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            int l = (int) in.nval;
            in.nextToken();
            int r = (int) in.nval;
            if (l != 0) {
                a[i].left = l;
                a[l].fa = i;
            }
            if (r != 0) {
                a[i].right = r;
                a[r].fa = i;
            }
        }
        preorder(1);
        sb.append("\n");
        inorder(1);
        sb.append("\n");
        postorder(1);
        System.out.println(sb);
    }

    private static void preorder(int t) {
        sb.append(t).append(" ");
        if (a[t].left != 0) {
            preorder(a[t].left);
        }
        if (a[t].right != 0) {
            preorder(a[t].right);
        }
    }

    private static void inorder(int t) {
        if (a[t].left != 0) {
            inorder(a[t].left);
        }
        sb.append(t).append(" ");
        if (a[t].right != 0) {
            inorder(a[t].right);
        }
    }

    private static void postorder(int t) {
        if (a[t].left != 0) {
            postorder(a[t].left);
        }
        if (a[t].right != 0) {
            postorder(a[t].right);
        }
        sb.append(t).append(" ");
    }
}
