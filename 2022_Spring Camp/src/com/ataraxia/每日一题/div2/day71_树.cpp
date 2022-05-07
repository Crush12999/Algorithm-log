#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll, ll> PII;
const int MOD = 1e9 + 7, N = 3010;

int n, f[N], w[N];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cin >> n;
    for (int i = 2; i <= n; i++) {
        int x;
        cin >> x;
        w[x]++;
    }
    memset(f, 0x3f, sizeof f);
    f[1] = 0;
    for (int i = 1; i <= n; i++) {
        if (w[i] == 0)continue;
        for (int j = n; j >= w[i]; j--)
            f[j] = min(f[j], f[j - w[i]] + 1);
    }
    for (int i = 1; i <= n; i++) {
        if (f[i] == 0x3f3f3f3f)cout << -1 << " ";
        else cout << f[i] << " ";
    }
    return 0;
}
