#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
const int N = 1010, MOD = 1000003;
ll f[N][N], s[N][N], v[N];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> v[i];
    }
    for (int i = 1; i <= n; i++) {
        s[i][i] = 1;
        s[i][i - 1] = 1;
        for (int j = i; j <= n; j++) {
            s[i][j] = (v[j] * s[i][j - 1]) % MOD;
        }
    }
    for (int len = 2; len <= n; len++) {
        for (int i = 1; i + len - 1 <= n; i++) {
            int j = i + len - 1;
            for (int k = i; k < j; k++) {
                f[i][j] = max(f[i][j], f[i][k] + f[k + 1][j] + (s[i][k] - s[k + 1][j]) * (s[i][k] - s[k + 1][j]));
            }
        }
    }
    cout << f[1][n] << endl;
    return 0;
}
