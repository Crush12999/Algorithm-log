package com.ming.luogu.sheet.ch02_基础算法.c2_排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ming
 * @create 2021-12-01
 * @description
 */
public class P1093_奖学金 {

    static class Student implements Comparable<Student> {

        int id;
        int chinese;
        int total;

        public Student() {
        }

        public Student(int id, int chinese, int total) {
            super();
            this.id = id;
            this.chinese = chinese;
            this.total = total;
        }


        @Override
        public String toString() {
            return id + " " + total;
        }

        @Override
        public int compareTo(Student o) {
            if (o.total != this.total) {
                return o.total - this.total;
            }
            if (o.chinese != this.chinese) {
                return o.chinese - this.chinese;
            }
            return this.id - o.id;
        }

    }

    static class InputReader {
        StreamTokenizer tokenizer;

        public InputReader(InputStream inputStream) {
            tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(inputStream)));
            tokenizer.ordinaryChars(33, 126);
            tokenizer.wordChars(33, 126);
        }

        public String next() throws IOException {
            tokenizer.nextToken();
            return tokenizer.sval;
        }

        public int nextInt() throws IOException {
            return Integer.valueOf(next());
        }

        public long nextLong() throws IOException {
            return Long.valueOf(next());
        }

        public boolean hasNext() throws IOException {
            int res = tokenizer.nextToken();
            tokenizer.pushBack();
            return res != StreamTokenizer.TT_EOF;
        }

    }

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        int n = in.nextInt();
        Student[] stus = new Student[n];

        for (int i = 0; i < n; i++) {
            int[] arr = new int[3];
            int count = 0;

            for (int j = 0; j < 3; j++) {
                arr[j] = in.nextInt();
                count += arr[j];
            }
            int chinese = Integer.valueOf(arr[0]);
            stus[i] = new Student(i + 1, chinese, count);
        }

        Arrays.sort(stus);
        for (int i = 0; i < 5; i++) {
            System.out.println(stus[i]);
        }
    }

}
