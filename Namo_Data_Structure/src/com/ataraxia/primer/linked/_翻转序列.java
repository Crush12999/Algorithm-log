package com.ataraxia.primer.linked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 翻转序列
 *
 * @author sryzzz
 * @create 2022/8/16 22:47
 * @description http://oj.daimayuan.top/course/7/problem/425
 */
public class _翻转序列 {

    private static class Node {
        int value;
        Node prev, next;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        Node[] a = new Node[n + 1];
        Node head = null, tail = null;
        for (int i = 1; i <= n; i++) {
            a[i] = new Node();
            a[i].value = i;
            if (head == null) {
                head = tail = a[i];
            } else {
                tail.next = a[i];
                a[i].prev = tail;
                tail = a[i];
            }
        }

        for (int i = 1; i <= m; i++) {
            in.nextToken();
            int l = (int) in.nval;
            in.nextToken();
            int r = (int) in.nval;

            if (l == r) {
                continue;
            }

            // pl：链表第 l 个，pr：链表第 r 个
            Node pl = head, pr = head;
            for (int j = 1; j < l; j++) {
                pl = pl.next;
            }
            for (int j = 1; j < r; j++) {
                pr = pr.next;
            }
            Node x = pl, y = pl.next, z, u = pr.next, v = pl.prev;
            while (x != pr) {
                z = y.next;
                y.next = x;
                x.prev = y;
                x = y;
                y = z;
            }
            if (head == pl) {
                head = pr;
                pr.prev = null;
            } else {
                Node plPrev = v;
                plPrev.next = pr;
                pr.prev = plPrev;
            }
            if (tail == pr) {
                tail = pl;
                pl.next = null;
            } else {
                Node prNext = u;
                prNext.prev = pl;
                pl.next = prNext;
            }

        }
        StringBuilder sb = new StringBuilder();
        for (Node p = head; p != null; p = p.next) {
            sb.append(p.value).append(" ");
        }
        System.out.println(sb);
    }
}
