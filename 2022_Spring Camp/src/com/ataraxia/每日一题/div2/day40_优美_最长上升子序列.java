package com.ataraxia.每日一题.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @author Ataraxia
 * @create 2022/4/6 22:46
 * @description
 * 选择的最长上升子序列，他们在数组v里的位置（从1开始，不是0）要呈倍数关系。
 * 那我从位置1开始，只看我枚举位置的倍数能不能凑成上升子序列就行。
 * 比如我枚举的位置是2，那我就看4 6 8……这些位置能不能和第二个位置凑成上升序列。
 * 我们可以准备一个dp数组，dp[i]的意思是，以v[i]为结尾的最长上升子序列的长度。
 * 我们就看，如果倍数位置j的数大于我们枚举的位置i的数，
 * 就看是当前dp[j]存的位置和dp[i]+1那个大。我们选最大的。
 * 最后输出dp数组里存储的最大值。
 */
public class day40_优美_最长上升子序列 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int t = (int) in.nval;
        while (t-- > 0) {
            int maxN = 1;
            in.nextToken();
            int n = (int) in.nval;
            int[] a = new int[n + 1];
            int[] dp = new int[n + 1];
            Arrays.fill(dp, 1);
            for (int i = 1; i <= n; i++) {
                in.nextToken();
                a[i] = (int) in.nval;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = i * 2; j <= n; j += i) {
                    if (a[j] > a[i]) {
                        dp[j] = Math.max(dp[j], dp[i] + 1);
                    }
                    maxN = Math.max(maxN, dp[j]);
                }
            }

            System.out.println(maxN);
        }
    }
}
