package com.ming.luogu.sheet.ch03_数据结构.ch1_线性表;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ming
 * @create 2021-12-18
 * @description
 */
public class P1996_约瑟夫问题 {

    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int n = sin.nextInt();
        int k = sin.nextInt();
        if (n == 0 || k == 0) {
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int i = 0;
        int j = 1;

        for (; ; ) {
            if (list.size() == 1) {
                System.out.print(list.get(0));
                break;
            }
            i++;
            j++;
            if (i == list.size()) {
                i = 0;
            }
            if (j == k) {
                System.out.print(list.get(i) + " ");
                list.remove(i);
                i--;
                j = 0;
            }

        }
    }

}
