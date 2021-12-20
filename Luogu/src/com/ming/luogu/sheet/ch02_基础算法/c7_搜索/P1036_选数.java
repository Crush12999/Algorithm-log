package com.ming.luogu.sheet.ch02_基础算法.c7_搜索;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author ming
 * @create 2021-12-20
 * @description
 */
public class P1036_选数 {


    static int[] arr;
    static int n;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n = (int) st.nval;
        st.nextToken();
        int k = (int) st.nval;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            arr[i] = (int) st.nval;
        }
        dfs(0, 0, 0, k);
        System.out.print(ans);

    }

    private static void dfs(int i, int j, int sum, int k) {
        if (i == k) {
            if (ps(sum)) {
                ans++;
            }
            return;
        } else if (j == n) {
            return;
        } else {
            dfs(i, j + 1, sum, k);
            dfs(i + 1, j + 1, sum + arr[j], k);
        }
    }

    private static boolean ps(int sum) {
        for (int i = 2; i < sum; i++) {
            if (sum % i == 0)
                return false;
        }
        return true;
    }

}
