package com.ming.luogu.sheet.ch03_数据结构;

import java.io.*;
import java.util.Scanner;

/**
 * @author ming
 * @create 2021-12-16
 * @description 巨坑~~~
 * c++使用dfs可以AC，Java用dfs第一和第三个测试点会RE，估计是栈溢出
 * 所以更新一下Java写法，用bfs跑
 * Java写算法还是用分词器吧，这题会比Scanner快3倍多，数据再大点差距更明显
 */
public class P4913_二叉树的深度 {

    static class MyInput {
        StreamTokenizer tokenizer;
        public MyInput(InputStream inputStream) {
            tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(inputStream)));
            tokenizer.ordinaryChars(33, 126);
            tokenizer.wordChars(33, 126);
        }

        public String next() throws IOException {
            tokenizer.nextToken();
            return tokenizer.sval;
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

    }

    static class Node {
        int id, l, r, deep;

        public Node() {
        }

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    static int n;
    static Node[] trees = new Node[101000];
    static Node[] que = new Node[101000];
    static int head, tail, depth;

    public static void main(String[] args) throws IOException {
        MyInput in = new MyInput(System.in);
//        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            trees[i] = new Node();
            trees[i].l = in.nextInt();
            trees[i].r = in.nextInt();
        }

        bfs();
        System.out.println(depth);
    }

    public static void bfs() {
        head = 1;
        tail = 2;
        que[head] = trees[1];
        que[head].id = 1;
        que[head].deep = 1;
        depth = 1;

        while (head < tail) {
            Node nowNode = que[head];
            head++;
            depth = Math.max(depth, nowNode.deep);
            if (nowNode.l != 0) {
                Node newNode = trees[nowNode.l];
                newNode.id = nowNode.l;
                newNode.deep = nowNode.deep + 1;
                que[tail++] = newNode;
            }
            if (nowNode.r != 0) {
                Node newNode = trees[nowNode.r];
                newNode.id = nowNode.r;
                newNode.deep = nowNode.deep + 1;
                que[tail++] = newNode;
            }
        }

    }
}
