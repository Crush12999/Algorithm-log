package com.ataraxia.每日一题.div2;

import java.util.Scanner;

/**
 * @author Ataraxia
 * @create 2022/3/29 22:44
 * @description 数位计算
 * 这里说的也很清楚了，f(x)的意思是，位数和x相等，但值大小不超过x的正整数的数量。
 * 那么f(x)的值就是：x-（当前位数的最小值）+1。比如f(152)=152-100+1=53;
 * 然后我们要算的是f(1)到f(x)的值的总和。
 * 如果你此时想的是计算每个f()的值加一起，请注意这里x最多有10e18，妥妥超时。
 * 但你要是聪明点，应该就能想到了，在x和x-1位数相等的情况下，f(x)=f(x-1)+1，
 * 这是一个公差为1的等差数列！
 * 而因为每个数位的f最小都是1（比如f(1),f(10),f(100)等），
 * 所以这就是个首项为1，公差为1的等差数列，当然前提是数位相同的情况下，
 * 那我们只要算出每个数位的等差数列前n项和即可，
 * 如果题目给的N不够当前数位的最大值了，那就以N做尾。
 * 计算所有前n项和的总和就是我们要的结果（几点取模）。
 */
public class day32_数位计算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long mod = 998244353;
        long n = sc.nextLong();
        long res = 0, power = 10;
        while (true) {
            if (n > power - 1) {
                long x = (1 + power - power / 10) % mod;
                long y = ((power - power / 10)) % mod;
                res = res + (x * y / 2) % mod;
                res %= mod;
            } else {
                long x = (1 + n - power / 10 + 1) % mod;
                long y = ((n - power / 10 + 1)) % mod;
                res = res + (x * y / 2) % mod;
                res %= mod;
                break;
            }
            power *= 10;
        }
        System.out.println(res % mod);
        sc.close();
    }
}
