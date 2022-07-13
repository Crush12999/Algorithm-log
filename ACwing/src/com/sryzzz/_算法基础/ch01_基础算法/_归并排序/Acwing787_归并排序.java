package com.sryzzz._算法基础.ch01_基础算法._归并排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/7/13 22:17
 * @description https://www.acwing.com/problem/content/789/
 */
public class Acwing787_归并排序 {

    public static void mergeSort(int[] nums, int temp[], int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + r >> 1;
        mergeSort(nums, temp, l, mid);
        mergeSort(nums, temp, mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= r) {
            temp[k++] = nums[j++];
        }
        for (i = l, j = 0; i <= r; i++, j++) {
            nums[i] = temp[j];
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        tokenizer.nextToken();
        int n = (int) tokenizer.nval;
        int[] nums = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            tokenizer.nextToken();
            nums[i] = (int) tokenizer.nval;
        }
        mergeSort(nums, temp, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]).append(" ");
        }
        System.out.println(sb);
    }
}
