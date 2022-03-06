#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int mod = 1e9 + 7;
int n;
int mp[110][110], dp[110][110];

int solve() {
    //f[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
    //初始化第一列的各个状态
    //&&运算符使得当有一个障碍时，从该障碍走的路径均为0
    for (int i = 0; i < n && mp[i][0] == 1; i++) {
        dp[i][0] = 1;
    }
    //初始化第一行的各个状态
    for (int j = 0; j < n && mp[0][j] == 1; j++) {
        dp[0][j] = 1;
    }
    for (int i = 1; i < n; i++) {
        for (int j = 1; j < n; j++) {
            if (mp[i][j] == 1) {
                dp[i][j] = ((dp[i - 1][j] % mod) + (dp[i][j - 1] % mod)) % mod;
            }
        }
    }
    return dp[n - 1][n - 1];
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> mp[i][j];
        }
    }
    cout << solve() << endl;
    return 0;
}
