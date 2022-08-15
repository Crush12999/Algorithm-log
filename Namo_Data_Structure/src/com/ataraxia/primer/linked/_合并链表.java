package com.ataraxia.primer.linked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/8/15 22:32
 * @description http://oj.daimayuan.top/course/7/problem/424
 */
public class _合并链表 {
    private static class Node {
        int value;
        Node next;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        Node[] a = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = new Node();
        }
        Node[] b = new Node[m + 1];
        for (int i = 0; i <= m; i++) {
            b[i] = new Node();
        }
        Node h1 = null, h2 = null, t1 = null, t2 = null;
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            a[i].value = (int) in.nval;
            if (h1 == null) {
                h1 = a[i];
            } else {
                t1.next = a[i];
            }
            t1 = a[i];
        }
        for (int i = 1; i <= m; i++) {
            in.nextToken();
            b[i].value = (int) in.nval;
            if (h2 == null) {
                h2 = b[i];
            } else {
                t2.next = b[i];
            }
            t2 = b[i];
        }
        Node p = merge(h1, h2);
        StringBuilder sb = new StringBuilder();
        for (; p != null; p = p.next) {
            sb.append(p.value).append(" ");
        }
        System.out.println(sb);
    }

    private static Node merge(Node h1, Node h2) {
        Node p1 = h1, p2 = h2;
        Node a = null, tail = null;
        while (p1 != null || p2 != null) {
            if (p1 != null && (p2 == null || p1.value < p2.value)) {
                if (a == null) {
                    a = tail = p1;
                } else {
                    tail.next = p1;
                    tail = p1;
                }
                p1 = p1.next;
            } else {
                if (a == null) {
                    a = tail = p2;
                } else {
                    tail.next = p2;
                    tail = p2;
                }
                p2 = p2.next;
            }
        }
        return a;
    }
}
