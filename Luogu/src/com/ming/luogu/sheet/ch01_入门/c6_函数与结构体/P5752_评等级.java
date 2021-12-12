package com.ming.luogu.sheet.ch01_入门.c6_函数与结构体;

import java.io.*;

/**
 * @author ming
 * @create 2021-12-12
 * @description
 */
public class P5752_评等级 {
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

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public boolean hasNext() throws IOException {
            int res = tokenizer.nextToken();
            tokenizer.pushBack();
            return res != StreamTokenizer.TT_EOF;
        }
    }

    static class Student {
        int no, score1, score2;
        double sumScore;
        public Student(int no, int score1, int score2) {
            this.no = no;
            this.score1 = score1;
            this.score2 = score2;
            this.sumScore = 0.7 * score1 + 0.3 * score2;
        }
    }

    public static void checkStudent(Student stu) {
        if (stu.score1 + stu.score2 > 140 && stu.sumScore >= 80) {
            System.out.println("Excellent");
        } else {
            System.out.println("Not excellent");
        }
    }

    public static void main(String[] args) throws IOException {
        MyInput in = new MyInput(System.in);
        int n = in.nextInt();
        Student stu;
        for (int i = 0; i < n; i++) {
            int no = in.nextInt();
            int score1 = in.nextInt();
            int score2 = in.nextInt();
            stu = new Student(no, score1, score2);
            checkStudent(stu);
        }

    }
}
