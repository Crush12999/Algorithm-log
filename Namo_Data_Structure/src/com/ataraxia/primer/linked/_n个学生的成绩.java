package com.ataraxia.primer.linked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * n 个学生的成绩
 *
 * @author sryzzz
 * @create 2022/8/16 22:26
 * @description http://oj.daimayuan.top/course/7/problem/390
 * 3 个一组去看前两个，避免指针修改后后一个找不到地址，然后修改前两个的指针指向，两两修改（后指向前），直到把链表反转
 */
public class _n个学生的成绩 {

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
        Node x = head;
        // z 不能是 y.next，否则如果 y 是 null，null.next 就爆炸了
        Node y = x.next, z;
        head.next = null;
        while (y != null) {
            z = y.next;
            y.next = x;
            x = y;
            y = z;
        }
        head = x;
        StringBuilder sb = new StringBuilder();
        for (Node p = head; p != null; p = p.next) {
            sb.append(p.value).append("\n");
        }
        System.out.print(sb);
    }
}
