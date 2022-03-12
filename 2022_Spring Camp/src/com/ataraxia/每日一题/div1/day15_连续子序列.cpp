#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
int n, a[N];
map<int, int> f;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    for (int i = 1; i <= n; ++i) {
        cin >> a[i];
    }

    int mx = 0;

    for (int i = 1; i <= n; i++) {
        f[a[i]] = max(f[a[i]], f[a[i] - 1] + 1);
        mx = max(mx, f[a[i]]);
    }

    for (auto &it : f) {
        if (it.second == mx) {
            int cnt = it.second, id = it.first;
            cout << cnt << "\n";
            for (int i = id - cnt + 1; i <= id; i++) {
                cout << i << " ";
            }
            cout << "\n";
            return 0;
        }
    }

    return 0;
}
