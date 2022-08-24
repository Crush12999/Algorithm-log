#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int n, m, x, b[200001];
unordered_map<int, int> c;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        cin >> x;
        c[x] = 1;
    }
    for (int i = 1; i <= m; i++) {
        cin >> b[i];
    }
    int x = 0;
    for (int i = 1; i <= m; i++) {
        if (c.find(b[i]) != c.end())
            x++;
    }
    if (2 * x >= m)
        cout << "Yes\n";
    else
        cout << "No\n";
    return 0;
}
