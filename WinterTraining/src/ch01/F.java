package ch01;

import java.util.Scanner;

/**
 * @author ming
 * @create 2022-01-19
 * @description Team CodeForces - 231A
 */
public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        while (n-- > 0) {
            int cnt = 0;
            int[] arr = new int[3];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();
            for (int i = 0; i < 3; i++) {
                if (arr[i] == 1) {
                    cnt++;
                }
            }
            if (cnt >= 2) {
                ans++;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
