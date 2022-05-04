#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int maxn = 1e6 + 10;
const int mod = 1e9 + 7;
ll a[maxn];

ll qpow(ll a, ll b) {
    ll ans = 1;
    if (b < 0) return 1;
    while (b) {
        if (b & 1) ans = ans * a % mod;
        a = a * a % mod;
        b >>= 1;
    }
    return ans;
}

int main() {
    int t;
    scanf("%d", &t);
    a[0] = 1;
    for (int i = 1; i < maxn; i++) {
        a[i] = a[i - 1] * i % mod;
    }
    while (t--) {
        int n;
        scanf("%d", &n);
        ll ans = ((a[n - 1] * (n - 2)) % mod + 2 * (a[n - 1] - qpow(2, n - 2) % mod) % mod + mod) % mod;
        printf("%lld\n", ans);
    }
    return 0;
}