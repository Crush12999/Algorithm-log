#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll ans;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int k, l = 0;
    string str;
    cin >> k >> str;
    int len = str.length();
    map<int, ll> mp;
    mp[0]++;

    vector<int> v(len + 1), s(len + 1);

    if (k == 0) {
        ll res = 0;
        str += '1';
        len++;
        for (int i = 0; i < len; i++) {
            if (str[i] == '0') {
                res++;
            } else {
                ans += (res + 1) * res / 2;
                res = 0;
            }
        }
    } else {
        for (int i = 1; i <= len; i++) {
            v[i] = str[i - 1] - '0';
            s[i] = v[i] + s[i - 1];
            mp[s[i]]++;
        }
        int res = 0;
        while (mp[res + k] != 0) {
            ans += mp[res] * mp[res + k];
            res++;
        }
    }

    cout << ans << endl;

    return 0;
}
