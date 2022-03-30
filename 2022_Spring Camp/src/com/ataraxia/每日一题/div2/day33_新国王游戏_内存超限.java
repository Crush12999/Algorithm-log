package com.ataraxia.每日一题.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ataraxia
 * @create 2022/3/30 22:12
 * @description 新国王游戏、、、、内存爆了
 */
public class day33_新国王游戏_内存超限 {

    static long mod = 1000000007;

    static class Node {
        long first, second;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        List<Node> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            v.add(new Node());
        }
        for (int i = 0; i < n; i++) {
            in.nextToken();
            v.get(i).first = (long) in.nval;
            in.nextToken();
            v.get(i).second = (long) in.nval;
        }

        v.sort((a, b) -> {
            return Long.compare(b.second + a.second * b.first, a.second + b.second * a.first);
        });

        long sum = 1, res = v.get(0).second;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                res = (res + (sum * v.get(i).second)%mod)%mod;
            }
            sum = (sum * v.get(i).first) % mod;
        }

        System.out.println(res % mod);

    }

}
