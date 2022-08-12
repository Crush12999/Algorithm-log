package com.ataraxia.primer.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/8/12 22:35
 * @description http://oj.daimayuan.top/course/7/problem/54
 */
public class _队列 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int m = (int) in.nval;
        int[] queue = new int[m + 1];
        int front = 1, rear = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            in.nextToken();
            String op = in.sval;
            if ("push".equals(op)) {
                in.nextToken();
                int x = (int) in.nval;
                queue[++rear] = x;
            } else if ("query".equals(op)) {
                in.nextToken();
                int x = (int) in.nval;
                sb.append(queue[x + front - 1]).append("\n");
            } else if ("pop".equals(op)) {
                front++;
            }
        }
        System.out.print(sb);
    }
}
