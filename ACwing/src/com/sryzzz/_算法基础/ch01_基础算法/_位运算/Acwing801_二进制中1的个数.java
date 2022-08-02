package com.sryzzz._算法基础.ch01_基础算法._位运算;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author sryzzz
 * @create 2022/8/2 23:31
 * @description https://www.acwing.com/problem/content/803/
 */
public class Acwing801_二进制中1的个数 {
    public static void main(String[] args) throws IOException {
        // StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        // in.nextToken();
        Scanner sc = new Scanner(System.in);
        // int n = (int) in.nval;
        int n = sc.nextInt();
        for (int i = 0 ; i < n ;i++) {
            // in.nextToken();
            // int q = (int) in.nval;
            int q = sc.nextInt();
            System.out.print(Integer.bitCount(q) + " ");
        }

        sc.close();
    }
}
