package com.ming.luogu.sheet.ch01_入门.c6_函数与结构体;

import java.util.Scanner;

/**
 * @author ming
 * @create 2021-11-29
 * @description 结构体、枚举
 */
public class P5741_旗鼓相当的对手加强版 {

    private static class Student {
        String name;
        int chinese;
        int math;
        int english;

        public Student(String name, int chinese, int math, int english) {
            this.name = name;
            this.chinese = chinese;
            this.math = math;
            this.english = english;
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        sc.nextLine();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String[] str = sc.nextLine().split(" ");
            students[i] = new Student(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]),Integer.parseInt(str[3]));
        }
        // 枚举学生
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (judge(students[i].chinese, students[j].chinese, 5)
                        && judge(students[i].math, students[j].math, 5)
                        && judge(students[i].english, students[j].english, 5)
                        && judge(students[i].chinese + students[i].math + students[i].english,
                        students[j].chinese + students[j].math + students[j].english, 10)) {
                    System.out.println(students[i].name + " " + students[j].name);
                }
            }
        }
        sc.close();
    }

    // 检查两数的差不超过z
    public static boolean judge(int x, int y, int z) {
        return x <= y + z && y <= x + z;
    }
}
