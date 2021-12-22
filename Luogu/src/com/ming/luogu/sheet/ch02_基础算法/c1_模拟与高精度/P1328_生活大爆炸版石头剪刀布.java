package com.ming.luogu.sheet.ch02_基础算法.c1_模拟与高精度;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author ming
 * @create 2021-12-22
 * @description
 */
public class P1328_生活大爆炸版石头剪刀布 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int m = (int) st.nval;
        st.nextToken();
        int k = (int) st.nval;
        int[] arrM = new int[m];
        int[] arrK = new int[k];
        for (int i = 0; i < m; i++) {
            st.nextToken();
            arrM[i] = (int) st.nval;
        }
        for (int i = 0; i < k; i++) {
            st.nextToken();
            arrK[i] = (int) st.nval;
        }
        int[][] ys = {{2, 0, 1, 1, 0}, {1, 2, 0, 1, 0}, {0, 1, 2, 0, 1}, {0, 0, 1, 2, 1,}, {1, 1, 0, 0, 2}};
        int flag1 = 0;    //代表第一个走到哪里
        int flag2 = 0;    //带包第二个走到哪里
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < n; i++) {
            if (ys[arrM[flag1]][arrK[flag2]] == 1) {
                ans1++;
            } else if (ys[arrM[flag1]][arrK[flag2]] == 0) {
                ans2++;
            }
            flag1++;
            flag2++;
            if (flag1 == m) flag1 = 0;
            if (flag2 == k) flag2 = 0;
        }
        System.out.print(ans1 + " " + ans2);

    }

}
