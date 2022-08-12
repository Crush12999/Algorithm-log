package com.ataraxia.primer.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/8/12 23:11
 * @description http://oj.daimayuan.top/course/7/problem/416
 *
 */
public class _排队买票 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        // 第 i 人想买 a[i] 张票
        int[] a = new int[n + 1];
        // 买完票的时间
        int[] b = new int[n + 1];
        int[] q = new int[n * n + 2];
        int front = 1, rear = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            in.nextToken();
            a[i] = (int) in.nval;
        }

        // 所有买票的人先入队
        for (int i = 1; i <= n; i++) {
            q[++rear] = i;
        }
        // 还有多少人要买票
        int cnt = n;
        for (int i = 1; cnt > 0; i++) {
            // 队首元素需求 - 1
            --a[q[front]];
            // 买完该跑路了
            if (a[q[front]] <= 0) {
                // 买完票的时间是 i
                b[q[front]] = i;
                cnt--;
            } else {
                // 重新排队
                q[++rear] = q[front];
            }
            front++;
        }
        // 输出答案
        for (int i = 1; i <= n; i++) {
            sb.append(b[i]).append(" ");
        }
        System.out.print(sb);
    }
}
