package com.ataraxia.primer.linked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

/**
 * @author Ataraxia
 * @create 2022/3/28 13:44
 * @description 数组模拟单链表
 */
public class _单链表 {

    static int N = 100010;
    // 头结点下标
    static int head;
    // val[i] 表示节点 i 的值是多少
    static int[] val = new int[N];
    // next[i] 表示节点 i 的下一个指针是多少
    static int[] next = new int[N];
    // 存储当前已经用到了哪个点
    static int idx;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        init();
        while (n-- > 0) {
            int k, x;
            in.nextToken();
            String op = in.sval;
            if ("H".equals(op)) {
                in.nextToken();
                x = (int) in.nval;
                insertHead(x);
            } else if ("D".equals(op)) {
                in.nextToken();
                k = (int) in.nval;
                if (k == 0) {
                    head = next[head];
                } else {
                    remove(k - 1);
                }
            } else {
                in.nextToken();
                k = (int) in.nval;
                in.nextToken();
                x = (int) in.nval;
                insert(k - 1, x);
            }
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = head; i != -1; i = next[i]) {
            sb.append(val[i]).append(" ");
        }
        System.out.println(sb);
    }

    /**
     * 初始化
     */
    public static void init() {
        // 头结点为空
        head = -1;
        // 当前可以从0号点开始可以使用
        idx = 0;
    }

    /**
     * 将x插入到头结点
     */
    public static void insertHead(int x) {
        val[idx] = x;
        next[idx] = head;
        head = idx;
        idx++;
    }

    /**
     * 将 x 插入到下标是 k 的节点后面
     * @param k 当前要插入到的节点位置
     * @param x 要插入的结点的值
     */
    public static void insert(int k, int x) {
        val[idx] = x;
        next[idx] = next[k];
        next[k] = idx;
        idx++;
    }

    /**
     * 将下标是 k 的节点后面的点删掉
     */
    public static void remove(int k) {
        next[k] = next[next[k]];
    }
}
