#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int t;
    cin >> t;
    while (t--) {
        string s1, s2;
        cin >> s1 >> s2;
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2) {
            cout << "NO" << endl;
            continue;
        }
        int s1_0 = 0, s1_1 = 0, s2_0 = 0, s2_1 = 0;
        for (int i = 0; i < len1; i++) {
            if (s1[i] == '0') {
                s1_0++;
            } else {
                s1_1++;
            }

            if (s2[i] == '0') {
                s2_0++;
            } else {
                s2_1++;
            }
        }
        if (s2_1 == 0 && s1_1 != 0) {
            cout << "NO" << "\n";
        } else if (s2_1 != 0 && s1_1 == 0) {
            cout << "NO" << "\n";
        } else {
            cout << "YES" << "\n";
        }
    }
    return 0;
}
