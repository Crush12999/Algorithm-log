#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int N = 110;
int f[N], mp[N];

int find(int x) {
    if (x != f[x])
        f[x] = find(f[x]);
    return f[x];
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n, x, y;
    cin >> n;
    vector<int> v(n);
    for (int i = 0; i < n; i++)cin >> v[i];
    for (int i = 1; i <= n; i++)f[i] = i, mp[i] = 1;
    for (int i = 1; i <= n; i++) {
        cin >> y;
        int a = find(i), b;
        if (i - y > 0) {
            b = find(i - y);
            if (a != b) {
                if (mp[a] > mp[b])swap(a, b);
                f[a] = b;
                mp[b] += mp[a];
            }
        }
        if (i + y <= n) {
            b = find(i + y);
            if (a != b) {
                if (mp[a] > mp[b])swap(a, b);
                f[a] = b;
                mp[b] += mp[a];
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        int a = find(i), b = find(v[i - 1]);
        if (a != b) {
            cout << "NO" << "\n";
            return 0;
        }
    }
    cout << "YES";
    return 0;
}
