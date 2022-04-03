package com.ataraxia.每日一题.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author Ataraxia
 * @create 2022/4/3 22:46
 * @description 组合数
 * 首先题目说了，每两个1直接要有k个0，
 * 按照样例来说，n=4，k=2的情况有0000，1000，0100，0010，0001和1001。
 *
 * 一直在变的其实是1的位置，0的位置不重要，我们只要保证两个1之间有k个0就行，
 * 剩下的位置可以随便排列。那我们就从0枚举1的数量i，然后剩下的位置全塞0就行，
 * 但0的数量最少要有（i-1）*k。为了方便其实我们可以忽略掉0，即把1都挨着，
 * 只要我们默认两个1之间有k个0就行，这样剩下01串的长度就是n-(i-1) *k，
 * 我们只要算在这个长度下，1能有多少种不同的排序即可。
 * 这就是高中知识了：C（i）(n-(i-1) *k)。
 * 至于C用代码怎么算这里便不多做展开了，感兴趣的可以自行百度学习。
 */
public class day37_01序列2 {

    static int mod = 1000000007;
    static int N = 1000007;
    static long[] fact = new long[N];
    static long[] inFact = new long[N];

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        init();
        int i = 1;
        long res = 1;
        while (i <= n - (i - 1) * k) {
            res = (res + C(n - (i - 1) * k, i) % mod) % mod;
            i++;
        }
        System.out.println(res);
    }

    public static long qmi(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }

    public static void init() {
        fact[0] = inFact[0] = 1;
        for (int i = 1; i < N; i++) {
            fact[i] = fact[i - 1] * i % mod;
        }
        inFact[N - 1] = qmi(fact[N - 1], mod - 2);
        for (int i = N - 2; i > 0; i--) {
            inFact[i] = inFact[i + 1] * (i + 1) % mod;
        }
    }

    public static long C(int a, int b) {
        return (fact[a] * inFact[b] % mod * inFact[a - b] % mod) % mod;
    }

}
