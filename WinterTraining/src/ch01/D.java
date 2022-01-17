package ch01;

import java.util.Scanner;

/**
 * @author ming
 * @create 2022-01-17
 * @description Watermelon CodeForces - 4A
 */
public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        if(w % 2 == 0 && w > 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}
