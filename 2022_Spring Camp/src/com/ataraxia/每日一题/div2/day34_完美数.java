package com.ataraxia.每日一题.div2;

import java.util.Scanner;

/**
 * @author Ataraxia
 * @create 2022/3/31 22:56
 * @description 完美数
 * 这题要求是，找出m位数的完美数。注意是m位数，比如5位数那就是10w，这里m最多可以取到10^6，
 * 这是相当吓人的，所以说也不用想着通过枚举来判断每一位是不是a或b了。
 * 但是我们完全可以反过来，既然好数是只有a和b的是数，那我们就用a和b排列出m位数，那他就是好数了。
 * 但完美数怎么办呢，一样的想法，完美数是好数各位数加起来仍然是好数，
 * 这里好数只有a和b组成，那么各位数之和就是x个a+y个b。
 * 我们只要枚举a或b的个数（x或y），然后计算出x*a+y *b，再看这个和是否是好数即可。
 * 如果是好数，那么说明x个a和y个b组成的m位数就将是个完美数。
 * 然后只要计算出他们的排列组合即可。
 */
public class day34_完美数 {

    static int mod = 1000000007;
    static int N = 1000010;
    static long[] fact = new long[N];
    static long[] inFact = new long[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long m = sc.nextLong();
        init();
        long x;
        long res = 0;
        for (int i = 0; i <= m; i++) {
            x = m - i;
            long num = x * a + b * i;
            boolean flag = true;
            while (num > 0) {
                if (num % 10 != a && num % 10 != b) {
                    flag = false;
                    break;
                }
                num /= 10;
            }
            if (!flag) {
                continue;
            }
            res = (res + C((int) m, i)) % mod;
        }
        System.out.println(res % mod);

        sc.close();
    }

    public static void init() {
        fact[0] = inFact[0] = 1;
        for (int i = 1; i < N; i++) {
            fact[i] = fact[i - 1] * i % mod;
        }
        inFact[N - 1] = fastPow(fact[N - 1], mod - 2);
        for (int i = N - 2; i > 0; i--) {
            inFact[i] = inFact[i + 1] * (i + 1) % mod;
        }
    }

    public static long C(int a, int b) {
        return (fact[a] * inFact[b] % mod * inFact[a - b] % mod) % mod;
    }

    public static long fastPow(long a, long b) {
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
}
