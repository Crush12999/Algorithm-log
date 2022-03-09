#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef pair<ll, ll> PII;
const int MOD = 1e9 + 7;
const int N = 200010;
ll f[N + 50][10];

int gcd(int a, int b) {
    while (b ^= a ^= b ^= a %= b);
    return a;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    ll n, x, y;
    vector<PII> v;
    cin >> n;
    map<PII, int> mymap;
    for (int i = 0; i < n; i++) {
        cin >> x >> y;
        v.emplace_back(x, y);
    }
    ll res = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (j == i)continue;
            int x = v[j].first - v[i].first;
            int y = v[j].second - v[i].second;
            if (x == 0 || y == 0) {
                x = x != 0 ? x / abs(x) : x;
                y = y != 0 ? y / abs(y) : y;
            } else {
                int num = abs(gcd(x, y));
                x /= num;
                y /= num;
            }
            if (mymap[{x, y}] == 0) {
                mymap[{x, y}] = 1;
                res++;
            }
        }
    }
    cout << res << endl;
    return 0;
}
