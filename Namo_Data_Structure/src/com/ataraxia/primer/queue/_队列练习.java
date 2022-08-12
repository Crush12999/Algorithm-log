package com.ataraxia.primer.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/8/12 22:45
 * @description http://oj.daimayuan.top/course/7/problem/56
 */
public class _队列练习 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int x = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        int[] queue = new int[2 * k + 5];
        int front = 1, rear = 0;
        queue[++rear] = x;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= k; i++) {
            queue[++rear] = queue[front] * 2;
            queue[++rear] = queue[front] * 2 + 1;
            sb.append(queue[front]).append("\n");
            front++;
        }
        System.out.print(sb);
    }
}
