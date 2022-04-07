package com.ataraxia.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ataraxia
 * @create 2022/4/7 22:10
 * @description
 */
public class Kruskal算法求最小生成树 {

    static int n , m;
    static Edge[] e;
    static int[] fa;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        e = new Edge[m + 1];
        fa = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            e[i] = new Edge();
        }
        for (int i = 1; i <= m; i++) {
            in.nextToken();
            e[i].u = (int) in.nval;
            in.nextToken();
            e[i].v = (int) in.nval;
            in.nextToken();
            e[i].w = (int) in.nval;
        }

        int ans = kruskal();
        if (ans == -1) {
            System.out.println("impossible");
        } else {
            System.out.println(ans);
        }

    }

    public static int find(int x) {
        if (fa[x] != x) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }

    public static int kruskal() {
        int ans = 0, numE = 0;
        for (int i = 1; i <= n; i++) fa[i] = i;
        Arrays.sort(e , 1, e.length);
        for (int i = 1; i <= m; i++) {
            int faU = find(e[i].u);
            int faV = find(e[i].v);
            if (faU != faV) {
                fa[faU] = faV;
                ans += e[i].w;
                numE++;
                if (numE == n - 1) {
                    break;
                }
            }
        }
        if (numE != n - 1) {
            return -1;
        } else {
            return ans;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v, w;

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}
