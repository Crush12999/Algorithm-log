package com.sryzzz._算法基础.ch01_基础算法._快速排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/7/12 23:15
 * @description https://www.acwing.com/problem/content/787/
 */
public class Acwing785_快速排序 {

    private static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = nums[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (nums[i] < mid);
            do {
                j--;
            } while (nums[j] > mid);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        quickSort(nums, l, j);
        quickSort(nums, j + 1, r);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        tokenizer.nextToken();
        int n = (int) tokenizer.nval;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            tokenizer.nextToken();
            nums[i] = (int) tokenizer.nval;
        }
        quickSort(nums, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]).append(" ");
        }
        System.out.println(sb);
    }
}
