package com.sryzzz._算法基础.ch01_基础算法._二分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/7/14 22:41
 * @description https://www.acwing.com/problem/content/791/
 */
public class Acwing789_数的范围 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        tokenizer.nextToken();
        int n = (int) tokenizer.nval;
        int[] nums = new int[n];
        tokenizer.nextToken();
        int m = (int) tokenizer.nval;
        for (int i = 0; i < n; i++) {
            tokenizer.nextToken();
            nums[i] = (int) tokenizer.nval;
        }

        while (m-- > 0) {
            tokenizer.nextToken();
            int k = (int) tokenizer.nval;
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] >= k) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (nums[l] != k) {
                System.out.println("-1 -1");
            } else {
                System.out.print(l + " ");
                l = 0;
                r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (nums[mid] <= k) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                System.out.println(l);
            }
        }
    }
}
