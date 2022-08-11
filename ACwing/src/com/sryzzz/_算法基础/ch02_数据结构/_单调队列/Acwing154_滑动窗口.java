package com.sryzzz._算法基础.ch02_数据结构._单调队列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author sryzzz
 * @create 2022/8/11 23:46
 * @description https://www.acwing.com/problem/content/156/
 */
public class Acwing154_滑动窗口 {

    public static void main(String[] args) throws IOException {
        // q[]存下标
        int[] q = new int[1000010];
        int[] a = new int[1000010];

        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            a[i] = (int) in.nval;
        }

        int head = 0;
        int tail = -1;
        StringBuilder minS = new StringBuilder();
        // 求滑动窗口中的最小值
        for (int i = 0; i < n; i++) {
            // 判断队头是否滑出窗口，队头小于队尾并且滑动窗口的起点大于队头存储的下标
            if (head <= tail && i - k + 1 > q[head]) {
                head++;
            }
            // 队列里只保留比新入队的数小的数
            while (head <= tail && a[q[tail]] >= a[i]) {
                tail--;
            }
            q[++tail] = i;
            if (i >= k - 1) {
                minS.append(a[q[head]]).append(" ");
            }
        }
        System.out.println(minS);

        head = 0;
        tail = -1;
        StringBuilder maxS = new StringBuilder();
        // 求滑动窗口中的最大值
        for (int i = 0; i < n; i++) {
            // 判断队头是否滑出窗口，队头小于队尾并且滑动窗口的起点大于队头存储的下标
            if (head <= tail && i - k + 1 > q[head]) {
                head++;
            }
            // 队列里只保留比新入队的数大的数
            while (head <= tail && a[q[tail]] <= a[i]) {
                tail--;
            }
            q[++tail] = i;
            if (i >= k - 1) {
                maxS.append(a[q[head]]).append(" ");
            }
        }
        System.out.println(maxS);
    }
}
