#include <bits/stdc++.h>

using namespace std;

int gcd(int a, int b) {
    if (a % b == 0)return b;
    return gcd(b, a % b);
}

bool dfs(int num, int k) {
    if (num < k)return false;
    bool a = false, b = false;
    if (num % 2 == 0)a = dfs(num / 2, k);
    if (num % 3 == 0)b = dfs(num / 3, k);
    return a || b || num == k;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> v(n);
        for (int i = 0; i < n; i++)cin >> v[i];
        int res = v[0];
        for (int i = 1; i < n; i++) {
            res = gcd(v[i], res);
        }
        bool flag = true;
        for (int i = 0; i < n; i++) {

            if (v[i] != res && !dfs(v[i], res)) {
                cout << "NO" << endl;
                flag = false;
                break;
            }
        }
        if (flag)cout << "YES" << endl;
    }
    return 0;
}
