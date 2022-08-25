#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int p = 9999971, base = 101;
const int p2 = 10000103, base2 = 137;
// c: base的i次方等于多少
int n, m, ha[200011], hb[200011], c[200011];
int ha2[200011], hb2[200011], c2[200011];
char a[200011], b[200011];
// 本题思路：把 b 的哈希值求出来，求 a 的所有长度 m 的哈希值，和 b 的哈希值比较
// 思考：如果询问对于 a 中所有位置 i，b和子串a[i]...a[n]的最长公共前缀是多少？

int main() {
    scanf("%d%d", &n, &m);
    scanf("%s%s", a + 1, b + 1);

    c[0] = 1;
    c2[0] = 1;
    for (int i = 1; i <= 200000; i++) {
        c[i] = c[i - 1] * base % p;
        c2[i] = c2[i - 1] * base2 % p2;
    }
    for (int i = 1; i <= n; i++) {
        ha[i] = (ha[i - 1] * base + a[i] - 'a') % p;
        ha2[i] = (ha2[i - 1] * base2 + a[i] - 'a') % p2;
    }
    for (int i = 1; i <= m; i++) {
        hb[i] = (hb[i - 1] * base + b[i] - 'a') % p;
        hb2[i] = (hb2[i - 1] * base2 + b[i] - 'a') % p2;
    }
    int ans = 0;
    for (int i = 1; i + m - 1 <= n; i++) {
        // 会爆int
        if ((ha[i + m - 1] - 1LL * ha[i - 1] * c[m] % p + p) % p == hb[m] &&
            (ha2[i + m - 1] - 1LL * ha2[i - 1] * c2[m] % p2 + p2) % p2 == hb2[m])
            ++ans;
    }
    printf("%d\n", ans);
    return 0;
}
