#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int N = 3e5 + 50;
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
    int n, m, x, y;
    cin >> n >> m;
    string s(n, 'A');
    for (int i = 1; i <= n; i++)f[i] = i, mp[i] = 1;
    for (int i = 0; i < m; i++) {
        cin >> x >> y;
        if (x != n && y != n) {
            int a = find(x), b = find(y);
            if (a != b) {
                if (mp[a] > mp[b])swap(a, b);
            }
            f[a] = b;
            mp[b] += mp[a];
        }
    }
    x = find(n - 1);
    s[n - 2] = 'B';
    for (int i = 1; i < n - 1; i++) {
        y = find(i);
        if (x == y)s[i - 1] = s[n - 2];
    }
    cout << s << endl;
    return 0;
}
