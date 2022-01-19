package ch01;

import java.util.Scanner;

/**
 * @author ming
 * @create 2022-01-19
 * @description Theatre Square CodeForces - 1A
 */
public class H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long a = sc.nextLong();
        long ans = (long) (Math.ceil(1.0 * n / a) * Math.ceil(1.0 * m / a));
        System.out.println(ans);
    }
}
