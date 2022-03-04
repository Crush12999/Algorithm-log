#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
// 饿饿 饭饭
// 二分
const int N = 1e6 + 7;
int n, a[N], b[N];
ll k, cnt;

ll solve(int x) {
    ll res = 0;
    for (int i = 1; i <= n; i++) {
        if (a[i] <= x) {
            res += a[i];
        } else {
            res += x;
        }
    }
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> k;

    for (int i = 1; i <= n; i++) {
        cin >> a[i];
        cnt += a[i];
    }

    if (cnt < k) {
        cout << "-1" << endl;
        return 0;
    }

    int l = 0, r = 1e9;
    while (l + 1 < r) {
        int mid = (l + r)  >> 1;
        if (solve(mid) <= k) {
            l = mid;
        } else {
            r = mid;
        }
    }

    k -= solve(l);
    int t = 0;
    for (int i = 1; i <= n; i++) {
        if (a[i] > l) {
            b[++t] = i;
        }
    }

    for (int i = k + 1; i <= t; i++) {
        cout << b[i] << " ";
    }

    for (int i = 1; i <= k; i++) {
        if (a[b[i]] != l + 1) {
            cout << b[i] << " ";
        }
    }

    return 0;
}
