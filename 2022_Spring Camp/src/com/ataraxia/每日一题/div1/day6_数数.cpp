#include <bits/stdc++.h>
using namespace std;
const int maxN = 1e5 + 7;
int n, t, q, tree[maxN], ans[maxN];

struct Node {
    int v, idx;
    bool operator < (const Node &a) const {
        return v < a.v;
    }
} a[maxN];

struct Operation {
    int l, r, h, idx;
    bool operator < (const Operation &a) const {
        return h < a.h;
    }
} op[maxN];

int lowbit(int x) {
    return x & (-x);
}

void update(int pos, int v) {
    while (pos < maxN) {
        tree[pos] += v;
        pos += lowbit(pos);
    }
}

int query(int pos) {
    int s = 0;
    while (pos) {
        s += tree[pos];
        pos -= lowbit(pos);
    }
    return s;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> t;
    while (t--) {
        memset(tree, 0, sizeof(tree));
        cin >> n >> q;
        for (int i = 1; i <= n; i++) {
            cin >> a[i].v;
            a[i].idx = i;
        }

        for (int i = 1; i <= q; i++) {
            cin >> op[i].l >> op[i].r >> op[i].h;
            op[i].idx = i;
        }
        sort(a + 1, a + n + 1);
        sort(op + 1, op + q + 1);

        for (int i = 1, j = 1; i <= q; i++) {
            while (j <= n && a[j].v <= op[i].h) {
                update(a[j].idx, 1);
                j++;
            }
            ans[op[i].idx] = query(op[i].r) - query(op[i].l - 1);
        }

        for (int i = 1; i <= q; i++) {
            cout << ans[i] << " ";
        }
    }

    return 0;
}
