#include <bits/stdc++.h>

using namespace std;
const int N = 5e5 + 10;
const int inf = 0x3f3f3f3f;
int pre[N], nxt[N];
int a[N];
int ans[N];
map<int, int> m1;
struct node {
    int l, r;
    int cnt;
} tr[N << 2];

struct qi {
    int l, r;
    int id;

    bool operator<(const qi &t) const {
        return l < t.l;
    }
} q[N];

void pushup(int u) {
    tr[u].cnt = min(tr[u << 1].cnt, tr[u << 1 | 1].cnt);
}

void build(int u, int l, int r) {
    if (l == r) {
        tr[u] = (node) {l, r};
        if (pre[l])
            tr[u].cnt = l - pre[l];
        else
            tr[u].cnt = inf;
    } else {
        tr[u] = (node) {l, r};
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
        pushup(u);
    }
}

void modify(int u, int x) {
    if (tr[u].l == tr[u].r) {
        tr[u].cnt = inf;
        return;
    }
    int mid = (tr[u].l + tr[u].r) >> 1;
    if (x <= mid)
        modify(u << 1, x);
    else
        modify(u << 1 | 1, x);
    pushup(u);
}

int query(int u, int l, int r) {
    if (tr[u].l >= l && tr[u].r <= r)
        return tr[u].cnt;
    int mid = (tr[u].l + tr[u].r) >> 1;
    int res = inf;
    if (l <= mid)
        res = query(u << 1, l, r);
    if (r > mid)
        res = min(res, query(u << 1 | 1, l, r));
    return res;
}

int main() {
    int n, m;
    cin >> n >> m;
    int i;
    for (i = 1; i <= n; i++) {
        scanf("%d", &a[i]);
        if (m1[a[i]]) {
            pre[i] = m1[a[i]], nxt[m1[a[i]]] = i, m1[a[i]] = i;
        } else {
            pre[i] = 0, m1[a[i]] = i;
        }
    }
    for (i = 1; i <= m; i++) {
        scanf("%d%d", &q[i].l, &q[i].r);
        q[i].id = i;
    }
    sort(q + 1, q + 1 + m);
    build(1, 1, n);
    int pos = 1;
    for (i = 1; i <= m; i++) {
        int l = q[i].l;
        int j;
        for (; pos < l; pos++) {
            if (nxt[pos] >= l) {
                modify(1, nxt[pos]);
            }

        }
        ans[q[i].id] = query(1, q[i].l, q[i].r);
    }
    for (i = 1; i <= m; i++) {
        if (ans[i] == inf)
            printf("-1\n");
        else
            printf("%d\n", ans[i]);
    }
    return 0;
}