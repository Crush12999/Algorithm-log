#include <bits/stdc++.h>
using namespace std;

int a[1001][1001], f[1001], n, m;

int main() {
    scanf("%d%d", &n, &m);
    memset(a, 127, sizeof(a));
    for (int i = 1; i <= m; i++) {
        int x, y, z;
        scanf("%d%d%d", &x, &y, &z);
        a[x][y] = min(a[x][y], z);
    }
    memset(f, 127, sizeof(f));
    f[1] = 0;
    for (int i = 2; i <= n; i++) {
        for (int j = 1; j < i; j++) {
            if (f[j] < 1 << 30 && a[j][i] < 1 << 30) {
                f[i] = min(f[i], f[j] + a[j][i]);
            }
        }
    }
    printf("%d\n", f[n]);

    return 0;
}
