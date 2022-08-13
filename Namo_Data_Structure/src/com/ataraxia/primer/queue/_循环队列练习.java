package com.ataraxia.primer.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/8/13 23:07
 * @description http://oj.daimayuan.top/course/7/problem/417
 */
public class _循环队列练习 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int m = (int) in.nval;
        // size 必须大于过程中的最大长度
        int size = 1001, front = 1, rear = 0;
        int[] q = new int[size + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            in.nextToken();
            String op = in.sval;
            if ("push".equals(op)) {
                in.nextToken();
                int x = (int) in.nval;
                rear = rear % size + 1;
                q[rear] = x;
            } else if ("pop".equals(op)) {
                front = front % size + 1;
            } else if ("query".equals(op)) {
                in.nextToken();
                int x = (int) in.nval;
                if (front + x - 1 <= size) {
                    sb.append(q[front + x - 1]).append("\n");
                } else {
                    sb.append(q[front + x - 1 - size]).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
