package com.ming.luogu.sheet.ch02_基础算法.c6_二分查找与二分答案;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @author ming
 * @create 2021-12-14
 * @description O(nlogn)的算法
 */
public class P1102_AB数对 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int c = (int) in.nval;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (long) in.nval;
        }
        Arrays.sort(arr);
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += upper_bound(arr, 0, n, arr[i] + c) - lower_bound(arr, 0, n, arr[i] + c);
        }
        System.out.println(sum);
    }

    /**
     * 在 [begin, end) 进行二分查找
     * @param arr 数组
     * @param begin 起始位置
     * @param end 终止位置
     * @param val 查找的值
     * @return 大于或等于 val 的第一个元素位置。如果所有元素都小于val，则返回end
     */
    public static int lower_bound(long[] arr, int begin, int end, long val) {
        while (begin < end) {
            // 防止溢出
            int mid = begin + (end - begin) / 2;
            // 当mid的元素小于val时
            if (arr[mid] < val) {
                // begin为 mid+1， arr[begin]的值会小于或等于val
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return begin;
    }

    /**
     * 在 [begin, end) 进行二分查找
     * @param arr 数组
     * @param begin 起始下标
     * @param end 终点下标
     * @param val 查找的值
     * @return  返回大于val的第一个元素位置。如果所有元素都小于val，则返回 end.
     */
    public static int upper_bound(long[] arr, int begin, int end, long val) {
        while (begin < end) {
            // 防止溢出
            int mid = begin + (end - begin) / 2;
            // 当mid的元素小于val时
            if (arr[mid] <= val) {
                // begin为 mid+1， arr[begin]的值会小于或等于val
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return begin;
    }
}
