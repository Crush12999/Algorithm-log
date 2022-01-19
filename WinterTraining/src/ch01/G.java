package ch01;

import java.util.Scanner;

/**
 * @author ming
 * @create 2022-01-19
 * @description Young Physicist CodeForces - 69A
 */
public class G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
            a += arr[i][0];
            b += arr[i][1];
            c += arr[i][2];
        }
        if (a == 0 && b == 0 && c == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
