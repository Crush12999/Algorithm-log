package com.ataraxia._2021省赛JavaB_第一场;

import java.util.Arrays;

/**
 * @author Ataraxia
 * @create 2022/4/6 10:55
 * @description 卡片
 */
public class _B_卡片 {
    public static void main(String[] args) {
        int[] card = new int[10];
        Arrays.fill(card, 2021);
        card[1]--;
        for (int i = 1; i <= 500000; i++) {
            char[] o = String.valueOf(i).toCharArray();
            for (int j = 0; j < o.length; j++) {
                if (card[o[j] - '0'] == 0) {
                    System.out.println(i);
                    return;
                }
                card[o[j] - '0']--;
            }
        }
    }
}
