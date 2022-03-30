package com.ataraxia.primer.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author Ataraxia
 * @create 2022/3/30 11:43
 * @description blah数集
 */
public class _Blah数集 {

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        long[] q = new long[1000010];
        long t1, t2, t;
        StringBuilder sb = new StringBuilder();
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int pa = 1, pb = 1;
            int a = (int) in.nval;
            q[1] = a;
            int tail = 2;
            in.nextToken();
            int n = (int) in.nval;
            while (tail <= n) {
                t1 = q[pa] * 2 + 1;
                t2 = q[pb] * 3 + 1;
                t = Math.min(t1, t2);
                if (t != q[tail - 1]) {
                    q[tail++] = t;
                }
                if (t1 < t2) {
                    pa++;
                } else {
                    pb++;
                }
            }
            sb.append(q[n]).append("\n");
        }

        System.out.print(sb);
    }
}
