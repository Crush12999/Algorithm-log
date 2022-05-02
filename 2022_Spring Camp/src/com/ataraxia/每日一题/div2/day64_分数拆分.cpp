#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    ll k, ans = 0;
    cin >> k;
//    vector<ll> X, Y;
    for (ll y = k + 1; y <= 2 * k; y++) {
        if (k * y % (y - k) == 0) {
            ans++;
//            X.push_back(k * y / (y - k));
//            Y.push_back(y);
        }
    }
//    cout << X.size() << endl;
    cout << ans << endl;
    return 0;
}
