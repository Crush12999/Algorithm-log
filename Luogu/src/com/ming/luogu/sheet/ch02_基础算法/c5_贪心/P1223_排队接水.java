package com.ming.luogu.sheet.ch02_基础算法.c5_贪心;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @author ming
 * @create 2021-12-04
 * @description 要用long来存结果
 */
public class P1223_排队接水 {

    static class A implements Comparable<A> {
        int no;
        int time;
        public A(int no, int time) {
            this.no = no;
            this.time = time;
        }

        @Override
        public int compareTo(A o) {
            if (o.time != this.time) {
                return this.time - o.time;
            }
            return this.no - o.no;
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        A[] a = new A[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            int time = (int) in.nval;
            a[i] = new A(i + 1, time);
        }
        Arrays.sort(a);
        long ans = 0, sum = 0;
        // 人数为n个，每个人的排队时间就是a[i]×(n-i),所以总时间sum就是每个人时间总和
        for (int i = 0; i < n; i++) {
            sum += (long) a[i].time * (n - i - 1);
            System.out.print(a[i].no + " ");
        }
        System.out.printf("\n%.2f\n", 1.0 * sum / n);

    }
}
