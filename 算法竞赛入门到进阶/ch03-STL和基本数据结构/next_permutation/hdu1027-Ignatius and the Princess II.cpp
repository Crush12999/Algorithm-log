// hdu1027 Ignatius and the Princess II
// 思路：先生成一个123...n的最小字典序列。
// 然后用next_permutation()一个一个生成下一个字典序更大的序列
#include <bits/stdc++.h>
using namespace std;
int a[1001], n, m;
int main() {
    while (cin >> n >> m) {
        for (int i = 1; i <= n; i++) {
            a[i] = i;	// 生成一个字典序最小的序列
        }
        int b = 1;
        do {
            if (b == m) {
                break;
            }
            b++;
        } while (next_permutation(a + 1, a + n + 1));	// 注意第一个是a+1，最后一个是a+n
        for (int i = 1; i < n; i++) {	// 输出 第 m 大的字典序
            cout << a[i] << " ";
        }
        cout << a[n] << "\n";
    }
    return 0;
}