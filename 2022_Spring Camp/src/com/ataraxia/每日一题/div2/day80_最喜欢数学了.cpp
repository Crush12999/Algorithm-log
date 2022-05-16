#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int N = 2e5 + 50;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int t;
    cin >> t;
    while (t--) {
        int x, y;
        cin >> x >> y;
        if (x == y) {
            cout << 0 << "\n";
        } else if (x > y) {
            if ((x - y) % 2 == 0) {
                cout << 1 << "\n";
            } else cout << 2 << "\n";
        } else {
            if ((y - x) % 2 == 1) {
                cout << 1 << "\n";
            } else if ((y - x) / 2 % 2 == 1) {
                cout << 2 << "\n";
            } else cout << 3 << "\n";
        }
    }
    return 0;
}
