package com.ataraxia.每日一题.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author Ataraxia
 * @create 2022/4/1 23:32
 * @description 贪心
 * 题目说要最初始能量最低，那么到达终点时所剩能量应该是0（能省则省）
 * 然后每跳一格，能量变化为：（e是下一层所剩能量，E是当前能量，H是下一层的高）
 *
 * 下一层高度大于E时：e-=H-E
 * 下一层高度小于E时：e+=E-H
 * 其实这里就可以看出来，到达下一层的能量变化就是e=E+(E-H)，只是根据下一层高度的不同括号里的结果分正负罢了。
 * 那么我们就可以根据：到达末尾能量为0和能量变化式e=E+(E-H)来进行反向操作，
 * 根据当前层剩的能量反向求上一层的能量，此时能量变化式变为了：E=(e+H)/2,但为了向上取整，
 * 我们给分式加上1，即E=(e+H+1)/2。
 * 此时问题就变成了：到达最后一层时能量为0，问最初开始时能量是多少。
 * 然后我们就可以从末尾出发，根据E=(e+H+1)/2一步步求上一层时能量，最后得到的结果就是开始时所需的最少能量。
 *
 * （但是当你用得到的能量正着求的时候会发现，到达终点并不是0，
 * 这是因为有前面的楼的高度做影响，我们要保证的是到达下一个楼高度后的能量最少，
 * 这个剩余的能量必须要足够我们跳到下下个楼，
 * 同时到下下个楼的时候我们要保证剩余的能量要能跳到下下下个楼。
 * 以此类推，而当我们跳到最后一个楼的时候，我们不用继续往下跳了，所以剩的能量可以是0。）
 */
public class day35_Lusir的游戏 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        //e是能量到达最后一层剩的能量
        int n, e = 0;
        in.nextToken();
        n = (int) in.nval;
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        //e是下一层时剩的能量，E是当前层能量，h是下一层的高
        //e=E+(E-h) ——> e=2E-h ——> E=(e+h)/2 ——>(为了向上取整我们将分数式+1）E=(e+h+1)/2
        //此时逆推，E就是上一层能量，e是当前能量
        for (int i = n - 1; i >= 0; i--) {
            e = (e + a[i] + 1) / 2;
        }
        System.out.println(e);
    }
}
