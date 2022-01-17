package ch01;

import java.util.Scanner;

/**
 * @author ming
 * @create 2022-01-17
 * @description  大小质数 51Nod - 1507
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = n + 1; ; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                break;
            }
        }
        for (int i = n - 1; i >= 2; i--) {
            if (isPrime(i)) {
                System.out.println(i);
                break;
            }
        }

        sc.close();
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
