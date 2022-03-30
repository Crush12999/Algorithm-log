package com.ataraxia.primer.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author Ataraxia
 * @create 2022/3/30 09:35
 * @description 栈
 */
public class _栈2 {

    static int[] s = new int[100010];
    static int top = 0;

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
            } else if ("pop".equals(op)) {
                pop();
            } else {
                in.nextToken();
                int k = (int) in.nval;
                sb.append(query(k));
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

    public static String query(int k) {
        return String.valueOf(s[top - k + 1]) + "\n";
    }
}
