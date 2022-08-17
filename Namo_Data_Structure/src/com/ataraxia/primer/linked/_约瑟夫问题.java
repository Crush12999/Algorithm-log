package com.ataraxia.primer.linked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 约瑟夫问题：循环链表
 * @author sryzzz
 * @create 2022/8/17 22:12
 * @description http://oj.daimayuan.top/course/7/problem/46
 */
public class _约瑟夫问题 {

    private static class Node {
        int value;
        Node next, prev;
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
        Node head = null, tail = null;
        for (int i = 1; i <= n; i++) {
            a[i].value = i;
            if (head == null) {
                head = tail = a[i];
            } else {
                tail.next = a[i];
                a[i].prev = tail;
                tail = a[i];
            }
        }
        tail.next = head;
        head.prev = tail;
        // 当前报到哪个人
        Node p = tail;
        // 报数
        int c = 0;
        StringBuilder sb = new StringBuilder();
        for (; ; ) {
            p = p.next;
            ++c;
            if (c == m) {
                sb.append(p.value).append(" ");
                // 只剩一个数的时候结束
                if (p == p.next) {
                    break;
                }
                Node x = p.prev, y = p.next;
                x.next = y;
                y.prev = x;
                p = x;
                c = 0;
            }
        }
        System.out.println(sb);
    }
}
