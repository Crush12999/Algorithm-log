package com.sryzzz._算法基础.ch03_搜索与图论.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * Dijkstra求最短路
 *
 * @author sryzzz
 * @create 2022/9/2 22:53
 * @description https://www.acwing.com/problem/content/description/851/
 */
public class Acwing849_Dijkstra求最短路 {
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
            mp[u][v] = Math.min(mp[u][v], w);
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
