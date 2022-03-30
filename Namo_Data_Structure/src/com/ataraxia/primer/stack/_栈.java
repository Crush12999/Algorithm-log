package com.ataraxia.primer.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author Ataraxia
 * @create 2022/3/30 09:22
 * @description 栈
 */
public class _栈 {

    static int[] s = new int[100010];
    static int top = -1;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int m = (int) in.nval;
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            int k;
            in.nextToken();
            String op = in.sval;
            if ("push".equals(op)) {
                in.nextToken();
                k = (int) in.nval;
                push(k);
            } else if ("pop".equals(op)) {
                pop();
            } else {
                sb.append(top());
            }
        }
        System.out.print(sb);
    }

    public static void push(int x) {
        s[++top] = x;
    }

    public static void pop() {
        top--;
    }

    public static String top() {
        return String.valueOf(s[top]) + "\n";
    }
}
