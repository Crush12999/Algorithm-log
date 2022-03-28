package com.ataraxia.primer.stack;

import java.io.*;

/**
 * @author Ataraxia
 * @create 2022/3/28 22:05
 * @description 模拟栈
 */
public class _模拟栈 {

    static class MyInput {
        StreamTokenizer tokenizer;
        public MyInput(InputStream inputStream) {
            tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(inputStream)));
            tokenizer.ordinaryChars(33, 126);
            tokenizer.wordChars(33, 126);
        }

        public String next() throws IOException {
            tokenizer.nextToken();
            return tokenizer.sval;
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

    }

    static int[] s = new int[100010];
    static int top = -1;

    public static void main(String[] args) throws IOException {
        MyInput in = new MyInput(System.in);
        int m = in.nextInt();
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            int x;
            String op = in.next();
            if ("push".equals(op)) {
                x = in.nextInt();
                push(x);
            } else if ("pop".equals(op)) {
                pop();
            } else if ("empty".equals(op)) {
                sb.append(empty());
            } else if ("query".equals(op)) {
                sb.append(query());
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
    public static String empty() {
        return top == -1 ? "YES\n" : "NO\n";
    }

    public static String query() {
        return String.valueOf(s[top]) + "\n";
    }



}
