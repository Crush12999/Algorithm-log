#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int mod = 9999971;
int n, m, a[200001], b[200001];
vector<int> c[mod];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
    }
    for (int i = 1; i <= m; i++) {
        cin >> b[i];
    }
    for (int i = 0; i < mod; i++) {
        c[i].clear();
    }
    for (int i = 1; i <= n; i++) {
        c[a[i] % mod].push_back(a[i]);
    }
    int x = 0;
    for (int i = 1; i <= m; i++) {
        int v = b[i] % mod;
        int l = c[v].size();
        bool ok = false;
        for (int j = 0; j < l && !ok; j++) {
            if (c[v][j] == b[i]) {
                ok = true;
            }
        }
        if (ok) {
            x++;
        }
    }
    if (2 * x >= m) {
        cout << "Yes\n";
    } else {
        cout << "No\n";
    }
    return 0;
}
