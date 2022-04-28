#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int N = 10007;
int n, m, c;
ll f[N], g[N];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    ll ans = 1e18, n, m, c;
    cin >> n >> m >> c;
    for (int i = 0; i < n; i++) {
        memcpy(f, g, sizeof g);
        for (int j = m - 2; j >= 0; j--)
            f[j] = min(f[j + 1] + c, f[j]);
        for (int j = 0; j < m; j++) {
            cin >> g[j];
            ll tmp = g[j] + c;
            if (i > 0) {
                ans = min(ans, f[j] + g[j]);
                tmp = min(tmp, f[j] + c);
            }
            if (j > 0) {
                ans = min(ans, g[j - 1] + g[j]);
                tmp = min(tmp, g[j - 1] + c);
            }
            g[j] = tmp;
        }
    }
    cout << ans << endl;
    return 0;
}
