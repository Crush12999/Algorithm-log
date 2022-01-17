package ch01;

import java.util.Scanner;

/**
 * @author ming
 * @create 2022-01-17
 * @description 蛇形填数 计蒜客 - T1410
 */
public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        int x, y;
        x = 1;
        y = n;
        arr[1][n] = 1;
        int cnt = 1;
        while (cnt < n * n) {
            // 向下
            while (x + 1 <= n && arr[x+1][y] == 0) {
                arr[++x][y] = ++cnt;
            }
            // 向左
            while (y - 1 >= 1 && arr[x][y-1] == 0) {
                arr[x][--y] = ++cnt;
            }
            // 向上
            while (x - 1 >= 1 && arr[x-1][y] == 0) {
                arr[--x][y] = ++cnt;
            }
            // 向右
            while (y + 1 <= n && arr[x][y+1] == 0) {
                arr[x][++y] = ++cnt;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
