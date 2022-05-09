#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    ll n;
    cin >> n;
    for (int i = 2; i * i <= n + 1; i++) {
        if (((n + 1) * n / 2) % i == 0) {
            cout << (n + 1) * n / 2 / i;
            return 0;
        }
    }
    if (n % 2 == 0) {
        cout << n + 1;
    } else {
        cout << n;
    }
    return 0;
}
