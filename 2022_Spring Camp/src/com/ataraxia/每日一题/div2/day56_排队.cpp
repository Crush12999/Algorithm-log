#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

/**
 * 只需交换第一队前两人，或者交换第二队前两人。这样人们都跟与自己身高相同的伙伴交谈，总体尴尬度为0，即最小。
 * 首先，要(a-b)2最小，把式子展开得到（a2-2*a *b-b2)，应该清楚，不管a和b位置如何，
 * 最后的结果a2和b2这两种情况是改不了的，所以我们只能从2ab上下手，然后通过这个式子我们也能看出，
 * 要想(a-b)2最小，那么2ab应该要最大。
 * 此时问题初步变成了，如何排序能让2ab最大。
 * 这里涉及到一个知识（我觉着挺神奇），就是说如果两个数组相乘，有序的数组相乘会大于无序的数组相乘。
 * 所以我们现在要做的就是把一个数组对于另一个数组相对有序：两边数组第一大的在同一个位置，
 * 第三大的在同一个位置，第二大的在同一个位置（不是说数组必须有序，而是相对有序）。
 * 现在题目最终变成了，每次可以交换两个相邻的数，问两个数组变的相对有序，步数最少是几步。
 * 这一步就相当于是求逆序对了，我们固定一个数组的顺序，仅改变另一个数组的值。
 * 那我们就根据固定的数组为准来离散化另一个数组，然后求出这个数组的逆序对数量，
 * 至于求逆序对用线段树或者逆序对都是可以的。
 */

typedef pair<ll, ll> PII;
const int N = 1e5 + 7, mod = 1e8 - 7;
ll f[4 * N];

void revise(int k, int l, int r, int x) {
    if (l == r) {
        f[k] += 1;
        return;
    }
    int m = (l + r) / 2;
    if (x <= m)revise(k + k, l, m, x);
    else revise(k + k + 1, m + 1, r, x);
    f[k] = (f[k + k] + f[k + k + 1]) % mod;
}

ll calc(int k, int l, int r, int x, int y) {
    if (l == x && y == r) {
        return f[k];
    }
    int m = (l + r) / 2;
    if (y <= m)return calc(k + k, l, m, x, y);
    else if (x > m)return calc(k + k + 1, m + 1, r, x, y);
    else return (calc(k + k, l, m, x, m) + calc(k + k + 1, m + 1, r, m + 1, y)) % mod;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n;
    cin >> n;
    vector<PII> a(n), b(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i].first;
        a[i].second = i;
    }
    for (int i = 0; i < n; i++) {
        cin >> b[i].first;
        b[i].second = i;
    }
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());

    vector<int> v(n);
    for (int i = 0; i < n; i++) {
        v[a[i].second] = b[i].second + 1;
    }
    ll res = 0;
    for (int i = n - 1; i >= 0; i--) {
        if (v[i] != 1) {
            res = (res + calc(1, 1, n, 1, v[i] - 1)) % mod;
        }
        revise(1, 1, n, v[i]);
    }
    cout << res << "\n";
    return 0;
}
