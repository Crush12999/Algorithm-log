#include <bits/stdc++.h>

using namespace std;

const int N = 1e5 + 7;

int t[N], a[1007], n;

int lowbit(int x) {
    return x & (-x);
}

void add(int x, int v) {
    for (int i = x; i < N; i += lowbit(i)) {
        t[i] = max(t[i], v);
    }
}

int query(int x) {
    int res = 0;
    for (int i = x; i; i -= lowbit(i)) {
        res = max(res, t[i]);
    }
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    int ans = 0;

    for (int i = 0; i < n; i++) {
        int temp = query(a[i] - 1) + a[i];
        add(a[i], temp);
        ans = max(ans, temp);
    }

    cout << ans << endl;

    return 0;
}
