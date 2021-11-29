package com.ming.luogu.sheet.ch01_入门.c6_函数与结构体;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ming
 * @create 2021-11-29
 * @description
 */
public class P5740_最厉害的学生 {

    private static class Student implements Comparable<Student> {
        int id;
        String name;
        int chinese;
        int math;
        int english;
        int total;

        public Student() {
        }

        public Student(int id, String name, int chinese, int math, int english) {
            this.id = id;
            this.name = name;
            this.chinese = chinese;
            this.math = math;
            this.english = english;
            this.total = chinese + math + english;
        }

        @Override
        public int compareTo(Student o) {
            if (o.total != this.total) {
                return o.total - this.total;
            }
            return this.id - o.id;
        }

        @Override
        public String toString() {
            return this.name + " " + this.chinese + " " + this.math + " " + this.english;
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] stus = new Student[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int chinese = sc.nextInt();
            int math = sc.nextInt();
            int english = sc.nextInt();
            stus[i] = new Student(i, name, chinese, math, english);
        }

        Arrays.sort(stus);
        System.out.println(stus[0]);
        sc.close();
    }
}
