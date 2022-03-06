#include <bits/stdc++.h>

using namespace std;
const int mod = 1e9 + 7;
const int N = 2e6 + 10;
struct Node {
    int r;
    int c;
} node[3005];
long long s[3005], c[N], inv[N];

bool cmp(Node a, Node b) {
    if (a.c == b.c) return a.r < b.r;
    return a.c < b.c;
}

void Getfac(int d) {
    c[0] = 1;
    for (int i = 1; i <= d; i++) {
        c[i] = c[i - 1] * i % mod;
    }
}

long long quick_inv(int n) {
    long long ans = 1, pos = n;
    int y = mod - 2;
    while (y) {
        if (y % 2) ans = ans * pos % mod;
        pos = pos * pos % mod;
        y = y / 2;
    }
    return ans % mod;
}

void Getinv(int d) {
    inv[d] = quick_inv(c[d]);
    for (int i = d - 1; i >= 0; i--) {
        inv[i] = inv[i + 1] * (i + 1) % mod;
    }
}

int main() {
    int h, n;
    long long k, t;
    scanf("%d%d", &h, &n);
    for (int i = 1; i <= n; i++) {
        scanf("%d%d", &node[i].r, &node[i].c);
    }
    node[0].r = 1;
    node[0].c = 1;
    node[n + 1].r = h;
    node[n + 1].c = h;
    s[0] = 1;
    sort(node + 1, node + n + 1, cmp);
    Getfac(h + h);
    Getinv(h + h);
    for (int i = 1; i <= n + 1; i++) {
        k = node[i].c - 1;
        t = node[i].r - 1;
        s[i] = c[k + t] * inv[k] % mod * inv[t] % mod;
        for (int j = 1; j < i; j++) {
            k = node[i].c - node[j].c;
            t = node[i].r - node[j].r;
            if (k >= 0 && t >= 0)
                s[i] -= c[k + t] * inv[k] % mod * inv[t] % mod * s[j] % mod;
        }
        s[i] = (s[i] + mod) % mod;
    }
    s[n + 1] = (s[n + 1] + mod) % mod;
    printf("%lld\n", s[n + 1]);
    return 0;
}

/**
* 题目大意：从点（1,1）走到（h,w），只能向右或向下，给出n个黑点点，不经过这些点走到（h,w）的路径有多少条（mod 1e9+7）
1≤h,w≤1e6,1≤n≤3000

思路：对于每个点i（x1,y1）,若不考虑黑点，从（1,1）到i有C(x1+y1-2)(x1-1)条路径
     考虑黑点，记s[i] = C(x1+y1-2)(x1-1),若存在点j(x2,y2)在点i的左上，则s[i]应该减去C(x1-x2+y1-y2)(x1-x2)*s[j],减去所有点i左上的黑点的影响，即得到s[i]

从右下第一个黑点计算到点(h,w)

C(x+y)(x) = c[x+y]*inv[x]*inv[y]%mod
c[k]:k的阶乘
inv[k]:k的逆元

逆元由公式inv[i] = inv[i+1] * (i+1) % mod 求得
*/