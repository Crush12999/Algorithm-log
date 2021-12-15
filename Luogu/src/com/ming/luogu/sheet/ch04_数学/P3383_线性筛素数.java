package com.ming.luogu.sheet.ch04_数学;

import java.io.*;

/**
 * @author ming
 * @create 2021-12-15
 * @description 踩坑了，交题的时候没注意数据范围，布尔数组需要开到10的9次方
 */
public class P3383_线性筛素数 {

    static int[] primes;
    static int cnt = 0;
    static boolean[] boolArray;
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        final int maxN = 10000010;
        boolArray = new boolean[100000010];
        primes = new int[maxN];
        boolArray[0] = boolArray[1] = true;

        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int q = (int) in.nval;

        for (int i = 2; i <= n; i++) {
            if (!boolArray[i]) {
                primes[cnt++] = i;
            }
            for (int j = 0; primes[j] <= n / i; j++) {
                boolArray[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < q; i++) {
            in.nextToken();
            int k = (int) in.nval;
            sb.append(primes[k - 1]).append("\n");
        }

        System.out.println(sb);

    }

}
