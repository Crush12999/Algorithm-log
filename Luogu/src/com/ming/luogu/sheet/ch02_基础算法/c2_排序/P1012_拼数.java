package com.ming.luogu.sheet.ch02_基础算法.c2_排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author ming
 * @create 2021-12-02
 * @description
 */
public class P1012_拼数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = sc.nextLine().split(" ");

        // 应该按照 s2 + s1 < s1 + s2排序，从而保证两个字符串拼接成的数是最大的
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        for (String s : arr) {
            System.out.print(s);
        }
        System.out.println();

        sc.close();
    }
}
