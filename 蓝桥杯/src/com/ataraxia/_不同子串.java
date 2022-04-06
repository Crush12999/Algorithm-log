package com.ataraxia;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ataraxia
 * @create 2022/4/6 22:34
 * @description
 */
public class _不同子串 {
    public static void main(String[] args) {
        String str = "0100110001010001";
        int ans = 0;
        char[] s = str.toCharArray();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            String resStr = "";
            for (int j = i; j < s.length; j++) {
                resStr += s[j];
                set.add(resStr);
            }
        }
        for (String it : set) {
            // System.out.println(it);
            ans++;
        }
        System.out.println(ans);
    }
}
