package com.ataraxia.primer.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/8/13 22:50
 * @description http://oj.daimayuan.top/course/7/problem/46
 */
public class _约瑟夫问题 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[] q = new int[n * m + 5];
        int front = 1, rear = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            q[++rear] = i;
        }
        int c = 0;
        // 队列不是空
        for (; rear >= front; ) {
            ++c;
            if (c == m) {
                sb.append(q[front]).append(" ");
                ++front;
                c = 0;
            } else {
                q[++rear] = q[front];
                ++front;
            }
        }
        System.out.print(sb);
    }
}
