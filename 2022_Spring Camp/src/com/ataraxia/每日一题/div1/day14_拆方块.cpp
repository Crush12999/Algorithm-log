#include <bits/stdc++.h>

using namespace std;

const int N = 1e5 + 7;

int n, ans, h[N], f1[N], f2[N];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin >> h[i];
    for (int i = 1; i <= n; i++)
        f1[i] = min(f1[i - 1] + 1, h[i]);
    for (int i = n; i >= 1; i--)
        f2[i] = min(f2[i + 1] + 1, h[i]);
    for (int i = 1; i <= n; i++)
        ans = max(ans, min(f1[i], f2[i]));

    cout << ans << endl;
    return 0;
}
