#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int maxn = 1005;
const int inf = 0x3f3f3f3f;
int t[maxn];
int f[maxn][maxn];
int n, m, q;
int x, y, tt;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    fill(f[0], f[0] + maxn * maxn, inf);
    fill(t, t + maxn, inf);
    cin >> n >> m;
    for (int i = 0; i < n; i++)
        cin >> t[i];
    for (int i = 0; i < m; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        f[u][v] = f[v][u] = w;
    }
    cin >> q;
    int k = 0;
    while (q--) {
        cin >> x >> y >> tt;
        while (t[k] <= tt) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (f[i][j] >= f[i][k] + f[k][j])
                        f[i][j] = f[i][k] + f[k][j];
                }
            }
            k++;
        }
        if (f[x][y] == inf || t[x] > tt || t[y] > tt) {
            cout << -1 << endl;
        } else
            cout << f[x][y] << endl;
    }
    return 0;
}
