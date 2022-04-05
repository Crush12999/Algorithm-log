package com.ataraxia.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @author Ataraxia
 * @create 2022/4/5 10:52
 * @description Dijkstra求最短路
 */
public class _Dijkstra求最短路_1 {

    static int INF = 0x3f3f3f3f;
    static int n, m;
    static int[][] mp = new int[510][510];
    static int[] dis = new int[510];
    static boolean[] vis = new boolean[510];

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;

        for (int i = 1; i <= n; i++) {
            Arrays.fill(mp[i], INF);
        }

        for (int i = 1; i <= m; i++) {
            int u, v, w;
            in.nextToken();
            u = (int) in.nval;
            in.nextToken();
            v = (int) in.nval;
            in.nextToken();
            w = (int) in.nval;
            mp[u][v] = Math.min(mp[u][v], w); // 防止重边问题
        }

        System.out.println(dijkstra(1));

    }

    public static int dijkstra(int s) {
        Arrays.fill(dis, INF);

        dis[s] = 0;

        for (int i = 1; i <= n; i++) {
            int minN = INF;
            int k = -1;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && dis[j] < minN) {
                    minN = dis[j];
                    k = j;
                }
            }

            if (k == -1) {
                return -1;
            }

            vis[k] = true;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && mp[k][j] != INF && dis[k] + mp[k][j] < dis[j]) {
                    dis[j] = dis[k] + mp[k][j];
                }
            }
        }
        if (dis[n] == INF) {
            return -1;
        }
        return dis[n];
    }
}
