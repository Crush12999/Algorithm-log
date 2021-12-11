package com.ming.luogu.sheet.ch02_基础算法.c7_搜索;

/**
 * @author ming
 * @create 2021-12-11
 * @description
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;

public class P1443_马的遍历 {
    static Queue<Integer> x = new LinkedList<>();
    static Queue<Integer> y = new LinkedList<>();
    static Queue<Integer> s = new LinkedList<>();
    static int[][] map = new int[405][405];
    static int n, m, tempx, tempy;
    static int[] tx = {-1, -2, 2, 1, -2, -1, 1, 2};
    static int[] ty = {-2, -1, -1, -2, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n = (int) st.nval;
        st.nextToken();
        m = (int) st.nval;
        st.nextToken();
        tempx = (int) st.nval;
        st.nextToken();
        tempy = (int) st.nval;
        for (int i = 1; i < 405; i++) {
            for (int j = 1; j < 405; j++) {
                map[i][j] = -1;
            }
        }
        x.offer(tempx);
        y.offer(tempy);
        s.offer(0);
        map[tempx][tempy] = 0;
        while (x.size() != 0) {
            for (int i = 0; i < 8; i++) {
                int dx = x.peek() + tx[i];
                int dy = y.peek() + ty[i];
                if (dx >= 1 && dx <= n && dy >= 1 && dy <= m && map[dx][dy] == -1) {
                    x.add(dx);
                    y.add(dy);
                    s.add(s.peek() + 1);
                    map[dx][dy] = s.peek() + 1;
                }
            }
            x.poll();
            y.poll();
            s.poll();
        }
        StringBuffer ans = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == -1) {
                    ans.append(map[i][j]).append("   ");
                } else if (map[i][j] < 10) {
                    ans.append(map[i][j]).append("    ");
                } else if (map[i][j] < 100) {
                    ans.append(map[i][j]).append("   ");
                } else if (map[i][j] < 1000) {
                    ans.append(map[i][j]).append("  ");
                } else if (map[i][j] < 10000) {
                    ans.append(map[i][j]).append(" ");
                }
            }
            ans.append("\n");
        }
        System.out.print(ans);

    }

}
