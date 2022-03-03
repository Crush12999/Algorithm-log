#include <bits/stdc++.h>

using namespace std;
const int maxn = 1e5 + 7;
int a[maxn], Hash[maxn];
int lson[maxn << 5], rson[maxn << 5], sum[maxn << 5];
int T[maxn];
int m, n, tot;

int build(int l, int r) {
    int rt = ++tot;
    sum[rt] = 0;
    if (l < r) {
        int mid = (l + r) / 2;
        lson[rt] = build(l, mid);
        rson[rt] = build(mid + 1, r);
    }
    return rt;
}

int update(int pre, int l, int r, int x) {
    int rt = ++tot;
    lson[rt] = lson[pre], rson[rt] = rson[pre], sum[rt] = sum[pre] + 1;
    if (l < r) {
        int mid = (l + r) / 2;
        if (x <= mid)
            lson[rt] = update(lson[pre], l, mid, x);
        else
            rson[rt] = update(rson[pre], mid + 1, r, x);
    }
    return rt;
}

int query(int u, int v, int l, int r, int k) {
    if (l >= r) return sum[v] - sum[u];
    int mid = (l + r) / 2;
    int ans = 0;
    if (k <= mid)
        ans += query(lson[u], lson[v], l, mid, k);
    else {
        ans += sum[lson[v]] - sum[lson[u]];
        ans += query(rson[u], rson[v], mid + 1, r, k);
    }
    return ans;
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        scanf("%d%d", &n, &m);
        tot = 0;
        for (int i = 1; i <= n; i++) {
            scanf("%d", &a[i]);
            Hash[i] = a[i];
        }
        sort(Hash + 1, Hash + 1 + n);
        int d = unique(Hash + 1, Hash + 1 + n) - Hash - 1;
        T[0] = build(1, d);
        for (int i = 1; i <= n; i++) {
            int x = lower_bound(Hash + 1, Hash + 1 + d, a[i]) - Hash;
            T[i] = update(T[i - 1], 1, d, x);
        }
        while (m--) {
            int l, r, h;
            scanf("%d%d%d", &l, &r, &h);
            int x = upper_bound(Hash + 1, Hash + 1 + d, h) - Hash - 1;    //用lower_bound还需要判断是否与h相等，不相等还需减1，而upper_bound直接减1即可
            if (x) printf("%d ", query(T[l - 1], T[r], 1, d, x));
            else puts("0");
        }
    }
    return 0;
}