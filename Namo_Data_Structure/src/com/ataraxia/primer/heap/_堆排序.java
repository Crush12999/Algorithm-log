package com.ataraxia.primer.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author Ataraxia
 * @create 2022/4/1 13:34
 * @description 堆排序
 */
public class _堆排序 {

    static int cnt = 0;
    static int[] heap = new int[100010];


    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            int x = (int) in.nval;
            insertHeap(x);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(deleteMin()).append(" ");
        }
        System.out.println(sb);

    }

    public static void insertHeap(int x) {
        int son = ++cnt;
        int pa = son / 2;
        heap[0] = 0xc0c0c0c0;
        while (x < heap[pa]) {
            heap[son] = heap[pa];
            son = pa;
            pa = son / 2;
        }
        heap[son] = x;
    }

    public static int deleteMin() {
        int root = heap[1];
        int t = heap[cnt--];
        int pa = 1;
        int son = pa * 2;
        while (son <= cnt) {
            if (son < cnt && heap[son + 1] < heap[son]) {
                son++;
            }
            if (t <= heap[son]) {
                break;
            }
            heap[pa] = heap[son];
            pa = son;
            son = pa * 2;
        }
        heap[pa] = t;
        return root;
    }
}
