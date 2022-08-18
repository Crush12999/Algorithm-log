package com.ataraxia.primer.binary_tree;

import java.util.Scanner;

/**
 * 遍历完全二叉树
 *
 * @author sryzzz
 * @create 2022/8/18 23:28
 * @description http://oj.daimayuan.top/course/7/problem/430
 */
public class _遍历完全二叉树 {

    private static StringBuilder sb;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sb = new StringBuilder();
        preorder(1);
        sb.append("\n");
        inorder(1);
        sb.append("\n");
        postorder(1);
        System.out.println(sb);
    }

    private static void preorder(int t) {
        sb.append(t).append(" ");
        if (t + t <= n) {
            preorder(t + t);
        }
        if (t + t + 1 <= n) {
            preorder(t + t + 1);
        }
    }

    private static void inorder(int t) {
        if (t + t <= n) {
            inorder(t + t);
        }
        sb.append(t).append(" ");
        if (t + t + 1 <= n) {
            inorder(t + t + 1);
        }
    }

    private static void postorder(int t) {
        if (t + t <= n) {
            postorder(t + t);
        }
        if (t + t + 1 <= n) {
            postorder(t + t + 1);
        }
        sb.append(t).append(" ");
    }

}
