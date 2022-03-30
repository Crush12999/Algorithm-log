package com.ataraxia.primer.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author Ataraxia
 * @create 2022/3/30 13:14
 * @description 模拟队列
 */
public class _模拟队列 {

    static int[] q = new int[100010];
    static int tail = 0;
    static int head = 0;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int m = (int) in.nval;
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            in.nextToken();
            String op = in.sval;
            int x;
            if ("push".equals(op)) {
                in.nextToken();
                x = (int) in.nval;
                push(x);
            } else if("pop".equals(op)) {
                pop();
            } else if ("empty".equals(op)) {
                sb.append(empty());
            } else {
                sb.append(query());
            }
        }
        System.out.println(sb);
    }
    public static void push(int x) {
        q[tail++] = x;
    }
    public static void pop() {
        head++;
    }
    public static String empty() {
        return head == tail ? "YES\n" : "NO\n";
    }
    public static String query() {
        return q[head] + "\n";
    }
}
