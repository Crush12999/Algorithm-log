//
// hdu2094 产生冠军
//

#include <bits/stdc++.h>
using namespace std;

int main() {
    set<string> a, b;
    string s1, s2;
    int n;
    while (cin >> n && n) {
        for (int i = 0; i < n; i++) {
            cin >> s1 >> s2;
            a.insert(s1); a.insert(s2); // 把所有人放进集合 a
            b.insert(s2);   // 把失败者放进集合 b
        }
        if (a.size() - b.size() == 1) {
            cout << "Yes" << endl;
        } else {
            cout << "No" << endl;
        }
        a.clear();
        b.clear();
    }
    return 0;
}