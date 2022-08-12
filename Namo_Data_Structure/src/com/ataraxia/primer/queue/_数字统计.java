package com.ataraxia.primer.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/8/12 22:58
 * @description http://oj.daimayuan.top/course/7/problem/415
 * 每统计一个数，就删除掉它前面的不满足 大于等于x-5 这个条件的所有数，答案就是 rear - front + 1
 */
public class _数字统计 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[] q = new int[n + 1];
        int front = 1, rear = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            in.nextToken();
            int x = (int) in.nval;
            for (; front <= rear && q[front] < x - 5; front++);
            sb.append(rear - front + 1).append(" ");
            q[++rear] = x;
        }
        System.out.print(sb);
    }
}
