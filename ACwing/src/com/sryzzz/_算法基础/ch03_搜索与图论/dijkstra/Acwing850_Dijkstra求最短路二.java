package com.sryzzz._算法基础.ch03_搜索与图论.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Dijkstra求最短路 II
 *
 * @author sryzzz
 * @create 2022/9/3 22:53
 * @description https://www.acwing.com/problem/content/description/852/
 */
public class Acwing850_Dijkstra求最短路二 {

    static class Node {
        int no;  // 边的编号
        int w;   // 权值或路径长度

        public Node(int no, int w) {
            this.no = no;
            this.w = w;
        }
    }

    static class MyCompare implements Comparator<Node> {    // 定义比较器，指定优先队列规则
        @Override
        public int compare(Node o1, Node o2) {
            return o1.w - o2.w;
        }
    }

    static class Edge {
        int to, w, next;

        public Edge() {
            this.w = INF;
        }
    }

    static int maxN = 150010;
    static int idx;
    static int[] head;
    static Edge[] e;
    static boolean[] vis;
    static int[] dis;
    static int INF = 0x3f3f3f3f;
    static int n, m;


    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;

        dis = new int[n + 1];
        head = new int[n + 1];
        vis = new boolean[n + 1];
        e = new Edge[m + 1];

        for (int i = 1; i <= m; i++) {
            e[i] = new Edge();
        }

        for (int i = 1; i <= m; i++) {
            in.nextToken();
            int u = (int) in.nval;
            in.nextToken();
            int v = (int) in.nval;
            in.nextToken();
            int len = (int) in.nval;
            add(u, v, len);
        }

        System.out.println(priorityDijkstra(1));
    }

    public static void add(int u, int v, int len) {
        ++idx;
        e[idx].w = len;
        e[idx].to = v;
        e[idx].next = head[u];
        head[u] = idx;    // 保存当前边编号
    }

    public static int priorityDijkstra(int s) {
        Queue<Node> q = new PriorityQueue<>(new MyCompare());   // 优先队列，类型为Node
        // 将起点add到堆中
        q.offer(new Node(s, 0));

        Arrays.fill(dis, INF);
        dis[s] = 0;

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            int no = tmp.no;

            if (vis[no]) {
                continue;
            }

            vis[no] = true; // 出队判重

            // 遍历这个点的所有通路
            for (int i = head[no]; i != 0; i = e[i].next) {
                int v = e[i].to;
                if (!vis[v] && dis[no] + e[i].w < dis[v]) {
                    dis[v] = dis[no] + e[i].w;
                    q.add(new Node(v, dis[v]));
                }
            }
        }
        if (dis[n] == INF) {
            return -1;
        }
        return dis[n];
    }
}
