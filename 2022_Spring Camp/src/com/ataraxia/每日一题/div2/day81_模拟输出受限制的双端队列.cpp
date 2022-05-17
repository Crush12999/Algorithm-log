#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int N = 1e5 + 50;
int n;
set<string> st;
string s;

void dfs(int len, string str, deque<char> de) {
    if (len == n) {
        while (!de.empty()) {
            str += de.front();
            de.pop_front();
        }
        st.insert(str);
        return;
    }
    de.push_front(s[len]);
    dfs(len + 1, str, de);
    de.pop_front();
    de.push_back(s[len]);
    dfs(len + 1, str, de);
    de.pop_back();
    while (!de.empty()) {
        str += de.front();
        de.pop_front();
        de.push_front(s[len]);
        dfs(len + 1, str, de);
        de.pop_front();
        de.push_back(s[len]);
        dfs(len + 1, str, de);
        de.pop_back();
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cin >> n >> s;
    deque<char> de;
    dfs(0, "", de);
    cout << st.size() << "\n";
    for (auto i: st) {
        cout << i << "\n";
    }
    return 0;
}
