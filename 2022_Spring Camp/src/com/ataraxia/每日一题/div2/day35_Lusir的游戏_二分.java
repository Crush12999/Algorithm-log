package com.ataraxia.每日一题.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author Ataraxia
 * @create 2022/4/1 23:39
 * @description 二分
 * 可以从1到1e6区间二分答案，每次去中间值看能否到达末尾，
 * 如果能到达说明这个能量还能少，我们去左区间继续找；
 * 如果到达不了说明能量不够，我们去右边继续找。
 * 为什么是上限是1e6?因为当你能量能大于当前高度数组的最大值时，
 * 你的能量就会一直增加了，而这题数据范围高度最多是1e5,所以我们取个1e6就可以。
 *
 * 但有一点要注意的是，因为当你能量x大于当前高度时，你的能量会加上x-h。
 * 这样如果你的初始能量过大，而且数组里的元素都远小于你时，
 * 相当于每跳一次你的能量就翻倍，数组最多有1e5项，
 * 那么你的能量就可能会过大而爆掉long long，这样会使得我们的结果有误差。
 * 所以要加一个特判，就像我们上面说的，当你的能量大于当前高度数组的最大值时，
 * 你的能量就会一直增加了。
 * 所以我们可以一开始先找到数组的最大值，然后当我们枚举的能量大于这个最大值时，
 * 就说明这个能量过大了，我们可以找更小的。
 */
public class day35_Lusir的游戏_二分 {

    static int mx = 0;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n, e = 0;
        n = (int) in.nval;
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            a[i] = (int) in.nval;
            mx = Math.max(mx, a[i]);
        }
        long l = 0, r = 1000000;
        while (l < r) {
            long mid = (l + r) >> 1;
            if (check(mid, a, n)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

    public static boolean check(long x, int[] a, int n) {
        for (int i = 0; i < n; i++) {
            x = x + (x - a[i]);
            if (x < 0) {
                return false;
            }
            if (x > mx) {
                return true;
            }
        }
        return true;
    }
}
