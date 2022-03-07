#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const long long mod = 998244353;

// time：O(logN)
// 这里不考虑指数为负数的情况
ll powMod(ll x, ll n, ll c) {
    ll res = 1;
    while (n) {
        if (n & 1)res = res * x % c;
        x = x * x % c;
        n >>= 1;
    }
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    ll a[110];
    int n, k;
    cin >> n >> k;
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
    }

    bitset<64> b;
    ll ans = 0;
    for (int i = 1; i <= n; i++) {
        bitset<64> t(a[i]);
        // cnt1 可选位置 且对应1， cnt0 可选位置对应为0
        ll cnt1 = 0, cnt0 = 0;
        for (int j = 0; j < k; j++) {
            if (b[j] == 0 && t[j] == 1) cnt1++;
            if (b[j] == 0 && t[j] == 0) cnt0++;
        }
        if (cnt1) {
            ans += i * ((powMod(2, cnt1, mod) - 1 + mod) % mod * (powMod(2, cnt0, mod)) % mod) % mod;
        }
        ans %= mod;
        b = b | t;  // 这一步的1的位置，下一步就不能选了
    }
    cout << ans << endl;
    return 0;
}
