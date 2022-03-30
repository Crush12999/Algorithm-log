#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll, ll> PII;
const int mod = 1000000007;

bool cmp(PII a, PII b) {
    return b.second + a.second * b.first < a.second + b.second * a.first;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n;
    cin >> n;
    vector<PII> v(n);
    for (int i = 0; i < n; i++)cin >> v[i].first >> v[i].second;
    sort(v.begin(), v.end(), cmp);
    ll sum = 1, res = v[0].second;
    for (int i = 0; i < n; i++) {
        if (i > 0)  res = (res + (sum * v[i].second) % mod) % mod;
        sum = (sum * v[i].first) % mod;
    }
    cout << res % mod << endl;
    return 0;
}
