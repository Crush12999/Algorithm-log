package com.ataraxia.每日一题.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ataraxia
 * @create 2022/3/28 22:25
 * @description A-B数对
 * 关于这题，如果我们按照题目说的找a和b来看看他们的差是否等于c，
 * 这样是相当麻烦的，相当于我们枚举A，其他的数当成B，进行计算看是否差值等于C，
 * 这样的时间复杂度是n^2，不用想肯定超时。所以我们要把问题转化一下：
 * 我们不知道数组里有哪些数可以和我当前枚举的数相差为C，
 * 但我们知道，我们当前枚举的数-c后得到的数是什么，
 * 那么我们只要看数组里有没有这个数，如果有，那就可以组成一个数对了，
 * 如果这个数有X个，那说明可以组成X个数对。
 * 先用哈希表跑一遍数组，记录每个数字的出现次数，
 * 然后再跑一边数组，看当前元素-c的数值是否在哈希表中被记录过，
 * 如果有，则计数器加上哈希表记录的值。最后输出计数器记录的值即可。
 */
public class day31_AB数对 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int c = (int) in.nval;
        long res = 0;
        int[] a = new int[n];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            in.nextToken();
            a[i] = (int) in.nval;
            if (map.get(a[i]) == null) {
                map.put(a[i], 1);
            } else {
                map.put(a[i], map.get(a[i]) + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (map.get(a[i] - c) != null) {
                res += map.get(a[i] - c);
            }
        }

        System.out.println(res);

    }
}
