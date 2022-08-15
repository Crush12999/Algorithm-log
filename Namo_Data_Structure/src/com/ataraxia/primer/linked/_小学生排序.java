package com.ataraxia.primer.linked;

import java.util.Scanner;

/**
 * @author sryzzz
 * @create 2022/8/15 22:16
 * @description http://oj.daimayuan.top/course/7/problem/223
 */
public class _小学生排序 {

    private static class Node {
        int value;
        Node next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node();
        }
        Node head = null;
        for (int i = 1; i <= n; i++) {
            nodes[i].value = sc.nextInt();
            if (head == null || nodes[i].value < head.value) {
                nodes[i].next = head;
                head = nodes[i];
            } else {
                for (Node p = head; p != null; p = p.next) {
                    if (p.value < nodes[i].value && (p.next == null || nodes[i].value < p.next.value)) {
                        nodes[i].next = p.next;
                        p.next = nodes[i];
                        break;
                    }
                }
            }
        }
        for (Node p = head; p != null; p = p.next) {
            System.out.printf("%d ", p.value);
        }
    }

}
