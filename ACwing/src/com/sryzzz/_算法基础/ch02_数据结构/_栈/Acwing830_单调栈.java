package com.sryzzz._算法基础.ch02_数据结构._栈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/8/10 23:12
 * @description https://www.acwing.com/problem/content/832/
 */
public class Acwing830_单调栈 {

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int m = (int) in.nval;
        int top = 0;
        int[] stack = new int[m + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            in.nextToken();
            int x = (int) in.nval;
            while (top > 0 && stack[top] >= x) {
                top--;
            }
            if (top > 0) {
                sb.append(stack[top]).append(" ");
            } else {
                sb.append("-1 ");
            }
            stack[++top] = x;
        }
        System.out.print(sb);
    }
}
