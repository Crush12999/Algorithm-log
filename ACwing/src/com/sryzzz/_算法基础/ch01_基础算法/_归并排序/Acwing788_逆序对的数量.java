package com.sryzzz._算法基础.ch01_基础算法._归并排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/7/13 22:17
 * @description https://www.acwing.com/problem/content/790/
 */
public class Acwing788_逆序对的数量 {

    public static long ans = 0;

    public static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + r >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int[] temp = new int[r - l + 1];
        int lPtr = l, rPtr = mid + 1, tempPtr = 0;
        while (lPtr <= mid && rPtr <= r) {
            if (nums[lPtr] <= nums[rPtr]) {
                temp[tempPtr++] = nums[lPtr++];
            } else {
                temp[tempPtr++] = nums[rPtr++];
                ans += (mid - lPtr + 1);
            }
        }
        while (lPtr <= mid) {
            temp[tempPtr++] = nums[lPtr++];
        }
        while (rPtr <= r) {
            temp[tempPtr++] = nums[rPtr++];
        }
        for (int i = l, j = 0; i <= r; i++, j++) {
            nums[i] = temp[j];
        }
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
        mergeSort(nums, 0, n - 1);
        System.out.println(ans);
    }
}
