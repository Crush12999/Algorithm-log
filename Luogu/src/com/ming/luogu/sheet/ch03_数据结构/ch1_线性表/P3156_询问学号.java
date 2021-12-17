package com.ming.luogu.sheet.ch03_数据结构.ch1_线性表;
import java.io.*;
/**
 * @author ming
 * @create 2021-12-17
 * @description
 */
public class P3156_询问学号 {
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

    public static void main(String[] args) throws IOException {
        MyInput in = new MyInput(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] arr = new int[2000010];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < m; i++) {
            int t = in.nextInt();
            sb.append(arr[t - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
