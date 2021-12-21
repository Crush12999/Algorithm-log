package com.ming.luogu.sheet.ch02_基础算法.c1_模拟与高精度;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author ming
 * @create 2021-12-21
 * @description
 */
public class P4924_魔法少女小Scarlet {

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int m = (int) st.nval;
        int[][] map = new int[n + 1][n + 1];
        int[][] vis = new int[n + 1][n + 1];
        int flag = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = flag;
                flag++;
            }
        }
        for (int p = 1; p <= m; p++) {
            st.nextToken();
            int x = (int) st.nval;
            st.nextToken();
            int y = (int) st.nval;
            st.nextToken();
            int r = (int) st.nval;
            st.nextToken();
            int z = (int) st.nval;

            //顺时针
            if (z == 0) {

                for (int i = x - r; i <= x + r; i++) {
                    for (int j = y - r; j <= y + r; j++) {
                        vis[i][j] = map[i][j];

                    }

                }

                int w = x - r;
                int l = y + r;
                for (int i = x - r; i <= x + r; i++) {
                    for (int j = y - r; j <= y + r; j++) {
                        map[w][l] = vis[i][j];
                        w++;
                        ;
                    }
                    l--;
                    w = x - r;
                }

            } else {

                for (int i = x - r; i <= x + r; i++) {
                    for (int j = y - r; j <= y + r; j++) {
                        vis[i][j] = map[i][j];
                    }
                }
                int w = x - r;
                int l = y - r;
                for (int i = x - r; i <= x + r; i++) {
                    for (int j = y + r; j >= y - r; j--) {
                        map[w][l] = vis[i][j];
                        w++;
                    }
                    l++;
                    w = x - r;
                }
            }
        }
        StringBuffer ansstr = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == n) {
                    ansstr.append(map[i][j]);
                } else {
                    ansstr.append(map[i][j] + " ");
                }

            }
            ansstr.append("\n");
        }
        System.out.print(ansstr);
    }

}
