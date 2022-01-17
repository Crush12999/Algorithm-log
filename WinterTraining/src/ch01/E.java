package ch01;

import java.util.Scanner;

/**
 * @author ming
 * @create 2022-01-17
 * @description Way Too Long Words CodeForces - 71A
 */
public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            StringBuilder sb = new StringBuilder("");
            int len = s.length();
            if (len > 10) {
                sb.append(s.charAt(0)).append(len-2).append(s.charAt(len-1));
                System.out.println(sb);
            } else {
                System.out.println(s);
            }
        }

        sc.close();
    }
}
