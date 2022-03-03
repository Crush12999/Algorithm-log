#include <bits/stdc++.h>
using namespace std;

int n;
set< pair<int, int> > c;

inline void insert(int l, int r) {
    if (l > r) {
        return;
    }
    c.insert(make_pair(r, l));
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n;
    c.insert(make_pair(2e9, 1));

    for (int i = 1; i <= n; i++) {
        int x;
        cin >> x;
        auto it = c.lower_bound(make_pair(x, 0));
        if (it->second <= x) {
            cout << x << " ";
            insert(it->second, x - 1);
            insert(x + 1, it->first);
            c.erase(it);
        } else {
            cout << it->second << " ";
            c.erase(it);
            insert(it->second + 1, it->first);
        }
    }
    return 0;
}
