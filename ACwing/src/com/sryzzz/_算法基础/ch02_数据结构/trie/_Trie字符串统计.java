package com.sryzzz._算法基础.ch02_数据结构.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * Trie字符串统计
 *
 * @author sryzzz
 * @create 2022/8/21 23:31
 * @description https://www.acwing.com/problem/content/837/
 */
public class _Trie字符串统计 {

    static int N = 100010;
    static int[][] son = new int[N][26];
    static int[] cnt = new int[N];
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            in.nextToken();
            String op = in.sval;
            in.nextToken();
            String str = in.sval;
            if ("I".equals(op)) {
                insert(str.toCharArray());
            } else {
                sb.append(query(str.toCharArray())).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void insert(char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] == 0) {
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
        cnt[p]++;
    }
    public static int query(char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            // 当前集合不存在这个字符
            if (son[p][u] == 0) {
                return 0;
            }
            // 否则走过去
            p = son[p][u];
        }
        return cnt[p];
    }
}
