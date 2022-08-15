package com.ataraxia.primer.linked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/8/15 22:51
 * @description http://oj.daimayuan.top/course/7/problem/479
 * 思路就是两个指针，一个一次走 2 格， 一个一次走 1 格，
 * 那么当 走2格 的指针走完时，走1格 的指针也刚好到一半
 */
public class _链表中间的元素 {
    private static class Node {
        int value;
        Node next;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        Node[] a = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = new Node();
        }
        Node head = null, tail = null;
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            a[i].value = (int) in.nval;
            if (head == null) {
                head = tail = a[i];
            } else {
                tail.next = a[i];
                tail = a[i];
            }
        }
        Node p1 = head, p2 = head;
        while (p2.next != null) {
            if (p2 == head) {
                p2 = p2.next;
            } else {
                p1 = p1.next;
                p2 = p2.next.next;
            }
        }
        System.out.println(p1.value);
    }
}
