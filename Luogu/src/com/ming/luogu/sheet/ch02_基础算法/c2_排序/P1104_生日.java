package com.ming.luogu.sheet.ch02_基础算法.c2_排序;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ming
 * @create 2021-12-02
 * @description
 */
public class P1104_生日 {

    static class Person implements Comparable<Person> {
        int id;
        String name;
        int y, m, d;
        public Person(int id, String name, int y, int m, int d) {
            this.id = id;
            this.name = name;
            this.y = y;
            this.m = m;
            this.d = d;
        }

        @Override
        public int compareTo(Person p) {
            if (this.y != p.y) {
                return this.y - p.y;
            }
            if (this.m != p.m) {
                return this.m - p.m;
            }
            if (this.d != p.d) {
                return this.d - p.d;
            }
            return p.id - this.id;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] arr = new Person[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] str = sc.nextLine().split(" ");
            arr[i] = new Person(i, str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]));
        }
        Arrays.sort(arr);
        for (Person p : arr) {
            System.out.println(p);
        }

        sc.close();
    }
}
