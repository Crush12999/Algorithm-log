#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int dp[1001][1001], n, t, x, y;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cin >> n >> t;
    while (t--) {
        cin >> x >> y;
        dp[x][y] = -1;
    }
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (dp[i][j] == 0) {
                dp[i][j] = min(dp[i - 1][j - 1] + 1, min(dp[i][j - 1], dp[i - 1][j]) + 1);
            } else {
                dp[i][j] = 0;
            }
            ans = max(dp[i][j], ans);
        }
    }
    cout << ans;
    return 0;
}
