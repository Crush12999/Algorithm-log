package com.ming.luogu.sheet.ch02_基础算法.c7_搜索;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author ming
 * @create 2021-12-19
 * @description
 */
public class P2392_Kkksc03考前临时抱佛脚 {

    static int[] temp = new int[4];
    static int[] ans = new int[4];

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        for (int i = 0; i < 4; i++) {
            st.nextToken();
            temp[i] = (int) st.nval;
        }
        for (int i = 0; i < 4; i++) {

            int[] arr = new int[temp[i]];
            for (int j = 0; j < temp[i]; j++) {
                st.nextToken();
                arr[j] = (int) st.nval;
            }
            ans[i] = Integer.MAX_VALUE;
            dfs(arr, 0, 0, 0, i);

        }

        System.out.print(ans[0] + ans[1] + ans[2] + ans[3]);
    }

    private static void dfs(int[] arr, int i, int z, int y, int i2) {
        if (i == arr.length) {
            int sum = Math.max(z, y);
            if (sum < ans[i2]) {
                ans[i2] = sum;
            }
            return;
        }
        dfs(arr, i + 1, z + arr[i], y, i2);
        dfs(arr, i + 1, z, y + arr[i], i2);
    }


}
