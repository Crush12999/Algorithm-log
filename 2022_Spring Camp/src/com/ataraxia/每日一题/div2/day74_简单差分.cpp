#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int N = 1e6 + 50;
/**
 * 因为这题的区间加操作都是前面一次性加完再询问区间和，所以我们可以先做出数组的差分数组，
 * 再通过差分数组实现区间加的过程。之后用前缀和将差分数组还原成普通数组，
 * 再进行一次前缀和做出前缀和数组，这样我们就可以O(1)的时间复杂度下求出数组的区间和。
 */
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    ll n, m, q, x, y, w;
    cin >> n >> m >> q;
    vector<ll> v(n + 1), s(n + 1), f(n + 1);
    for (int i = 0; i < n; i++) {
        cin >> v[i];
        if (i == 0)f[i] = v[i];
        else f[i] = v[i] - v[i - 1];
    }
    while (m--) {
        cin >> x >> y >> w;
        f[x - 1] += w;
        f[y] -= w;
    }
    s[0] = f[0];
    for (int i = 1; i < n; i++)s[i] = s[i - 1] + f[i];
    for (int i = 1; i < n; i++)s[i] += s[i - 1];

    while (q--) {
        cin >> x >> y;
        cout << s[y - 1] - (x == 1 ? 0 : s[x - 2]) << "\n";
    }
    return 0;
}
