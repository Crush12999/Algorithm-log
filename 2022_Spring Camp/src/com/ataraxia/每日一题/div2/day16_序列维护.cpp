#include <bits/stdc++.h>
using namespace std;

const int N = 1010;

int m;
vector<int> v;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cin >> m;
    while (m--) {
        string s;
        int k, x;
        cin >> s;
        if (s == "insert") {
            cin >> k >> x;
            v.insert(v.begin() + k, x);
        } else if (s == "delete") {
            cin >> k;
            v.erase(v.begin() + k - 1);
        } else if (s == "query") {
            cin >> k;
            cout << v[k - 1] << "\n";
        }
    }
    return 0;
}
