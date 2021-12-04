package com.ming.luogu.sheet.ch02_基础算法.c5_贪心;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
/**
 * @author ming
 * @create 2021-12-04
 * @description 经典作业贪心题、贪心策略：优先结束时间最早的
 */
public class P1803_凌乱的yyy_线段覆盖 {
    public static void main(String[] args) throws IOException {
        int ans = 1;
        int n = Reader.nextInt();

        Match[] m = new Match[n];

        for (int i = 0; i < n; i++) {
            m[i] = new Match();
            m[i].begin = Reader.nextInt();
            m[i].end = Reader.nextInt();
        }
        Arrays.sort(m, new Comparator<Match>() {
            @Override
            public int compare(Match o1, Match o2) {
                if (o1.end == o2.end) {
                    return o1.begin - o2.begin;
                }
                return o1.end - o2.end;
            }
        });
        int end_min = m[0].end;

        for (int i = 0; i < n; i++) {
            if (end_min <= m[i].begin) {
                end_min = m[i].end;
                ans++;
            }
        }
        System.out.println(ans);
    }

    /** 快速输入类 */
    static class Reader {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tokenizer = new StringTokenizer("");
        /** 获取下一段文本 */
        static String next() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }
        static int nextInt() throws IOException {
            return Integer.parseInt( next() );
        }
        static double nextDouble() throws IOException {
            return Double.parseDouble( next() );
        }
    }

    static class Match {
        int begin, end;
    }
}
