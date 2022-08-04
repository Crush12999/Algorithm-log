package com.sryzzz._算法基础.ch02_数据结构._链表;

import java.io.*;

/**
 * @author sryzzz
 * @create 2022/8/4 23:19
 * @description https://www.acwing.com/problem/content/829/
 */
public class Acwing827_双链表 {
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

    static int N = 100010;

    // e[i] 表示节点 i 的值是多少
    static int[] e = new int[N];
    // l[i]、r[i] 表示节点 i 的上一个以及下一个指针是多少
    static int[] l = new int[N];
    static int[] r = new int[N];
    // 存储当前已经用到了哪个点
    static int idx;

    public static void main(String[] args) throws IOException {
        MyInput in = new MyInput(System.in);
        int m = in.nextInt();
        init();
        while (m-- > 0) {
            String op = in.next();
            int k, x;
            if ("L".equals(op)) {
                x = in.nextInt();
                insert(0, x);
            } else if ("R".equals(op)) {
                x = in.nextInt();
                insert(l[1], x);
            } else if ("D".equals(op)) {
                k = in.nextInt();
                remove(k + 1);
            } else if ("IL".equals(op)) {
                k = in.nextInt();
                x = in.nextInt();
                insert(l[k + 1], x);
            } else if ("IR".equals(op)) {
                k = in.nextInt();
                x = in.nextInt();
                insert(k + 1, x);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = r[0]; i != 1; i = r[i]) {
            sb.append(e[i]).append(" ");
        }
        System.out.println(sb);
    }

    /**
     * 初始化
     */
    public static void init() {
        // 0表示左端点，1表示右端点
        r[0] = 1;
        l[1] = 0;
        idx = 2;
    }

    /**
     * 插入节点，在第k个点的右边插入节点x
     */
    public static void insert(int k, int x) {
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx;
        idx++;
    }

    /**
     * 删除第k个点
     */
    public static void remove(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }
}
