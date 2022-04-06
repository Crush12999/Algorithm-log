package com.ataraxia._2021省赛JavaB_第一场;

import java.util.Arrays;

/**
 * @author Ataraxia
 * @create 2022/4/6 11:22
 * @description 路径
 */
public class _E_路径 {

    static int INF = 0x3f3f3f3f;
    static boolean[] vis = new boolean[2022];
    static int[][] mp = new int[2022][2022];
    static int[] dis = new int[2022];
    static int n, m;

    public static void main(String[] args) {
        n = 2021;

        for (int i = 1; i <= n; i++) {
            Arrays.fill(mp[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n + 1 && j <= i + 21; j++) {
                if (mp[i][j] == INF) {
                    int d = gcd(i, j);
                    mp[i][j] = lcm(i, j, d);
                }
            }
        }

        System.out.println(dijkstra(1));

    }

    public static int dijkstra(int s) {
        Arrays.fill(dis, INF);
        dis[s] = 0;
        for (int i = 1; i <= n; i++) {
            int k = 0;
            int minN = INF;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && dis[j] < minN) {
                    minN = dis[j];
                    k = j;
                }
            }
            vis[k] = true;

            for (int j = 1; j <= n; j++) {
                if (!vis[j] && dis[k] + mp[k][j] < dis[j]) {
                    dis[j] = dis[k] + mp[k][j];
                }
            }
        }
        return dis[n];
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b, int d) {
        return a / d * b;
    }


}
