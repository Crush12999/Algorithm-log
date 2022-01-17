package ch01;

import java.util.Scanner;

/**
 * @author ming
 * @create 2022-01-17
 * @description 幸运数字们 51Nod - 2091
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        boolean flag = true;
        for (int i = l; i <= r; i++) {
            int k = i;
            while (k > 0) {
                if (k % 10 == 7) {
                    System.out.println(i);
                    flag = false;
                    break;
                }
                k /= 10;
            }
        }
        if (flag) {
            System.out.println("None");
        }
        sc.close();
    }
}
