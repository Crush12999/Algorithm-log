package com.sryzzz._算法基础.ch03_搜索与图论.bfs;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 走迷宫
 *
 * @author sryzzz
 * @create 2022/8/28 23:03
 * @description https://www.acwing.com/problem/content/description/846/
 */
public class Acwing844_走迷宫 {
    static int[][] map = new int[110][110];
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int n, m;

    static class Node {
        int x, y, step;

        public Node() {
        }

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int p = in.nextInt();
                map[i][j] = p;
            }
        }

        bfs();

        in.close();
    }

    public static void bfs() {
        Node node = new Node(1, 1, 0);
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        map[node.x][node.y] = 1;

        while (!q.isEmpty()) {
            Node p = q.poll();
            if (p.x == n && p.y == m) {
                System.out.println(p.step);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int tx = p.x + dx[i];
                int ty = p.y + dy[i];
                if (tx >= 1 && tx <= n && ty >= 1 && ty <= m && map[tx][ty] != 1) {
                    q.offer(new Node(tx, ty, p.step + 1));
                    map[tx][ty] = 1;
                }
            }
        }
    }
}
