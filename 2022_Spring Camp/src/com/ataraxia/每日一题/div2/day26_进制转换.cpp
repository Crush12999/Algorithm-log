#include <bits/stdc++.h>

using namespace std;
// 先把所有读到的t进制数转换成10进制并计算总和，再把总和转换成m进制。
typedef long long ll;
char v[70];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n, m;
    vector<ll> mp(100);
    ll ans = 36;
    for (char c = 'a'; c <= 'z'; c++) {
        v[ans] = c;
        mp[c - 65] = ans++;
    }
    for (char c = '0'; c <= '9'; c++)
        v[c - '0'] = c;
    ans = 10;
    for (char c = 'A'; c <= 'Z'; c++) {
        v[ans] = c;
        mp[c - 65] = ans++;
    }
    ll sum = 0;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        string s;
        int t;
        cin >> t >> s;
        ans = 1;
        int len = s.size();
        for (int j = len - 1; j >= 0; j--) {
            if (s[j] >= '0' && s[j] <= '9')sum += (s[j] - '0') * ans;
            else sum += mp[s[j] - 65] * ans;
            ans *= t;
        }
    }
    string str;
    while (sum) {
        ll num = sum % m;
        str += v[num];
        sum /= m;
    }
    reverse(str.begin(), str.end());
    cout << str << endl;
    return 0;
}
