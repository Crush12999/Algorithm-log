#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int t;
    cin >> t;

    while (t--) {
        char c = '#';
        int n, res = 1e9;
        bool flag = true;
        string str;
        cin >> n >> str;
        for (char i = 'a'; i <= 'z'; i++) {
            bool flag = true;
            int l = 0, r = n - 1, ans = 0;
            while (l < r) {
                if (str[l] == str[r])l++, r--;
                else {
                    if (str[l] == i)l++, ans++;
                    else if (str[r] == i)r--, ans++;
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag)res = min(res, ans);
        }
        if (res == 1e9)cout << -1 << '\n';
        else cout << res << '\n';
    }

    return 0;
}
