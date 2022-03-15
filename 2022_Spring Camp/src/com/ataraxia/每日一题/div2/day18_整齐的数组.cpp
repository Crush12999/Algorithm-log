#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MOD = 1e9 + 7;
const int N = 1e5 + 10;
ll a[N], b[N], w[N], v[N], f[N];

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, res = 0, min_num = 1e9, k = -1;
        cin >> n;
        vector<int> v(n + 1);
        for (int i = 1; i <= n; i++) {
            cin >> v[i];
            min_num = min(min_num, v[i]);
        }
        map<int, int> mymap;
        for (int i = 1; i <= n; i++) {
            if (v[i] != min_num) {
                int ans = v[i] - min_num;
                for (int j = 1; j * j <= ans; j++) {
                    if (ans % j == 0) {
                        mymap[j]++;
                        mymap[ans / j]++;
                    }
                }
            } else {
                res++;
            }
        }
        for (auto i: mymap) {
            if (i.second >= n - res)k = max(k, i.first);
        }
        cout << k << '\n';
    }
    return 0;
}
