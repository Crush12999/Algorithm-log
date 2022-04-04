#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int N = 1000050, MOD = 1e9 + 7;
int n;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cin >> n;
    int r = 1, ans = 1;
    while (r < n) {
        r *= 10;
        r += 1;
        ans++;
    }
    while (true) {
        cout << r / n;
        r %= n;
        if (r == 0) {
            break;
        }
        ans++;
        r *= 10;
        r += 1;
    }
    cout << " ";
    cout << ans;
    return 0;
}
