#include <bits/stdc++.h>

#define endl '\n';
using namespace std;
typedef long long ll;

const int N = 1e6 + 50;
int f[N], n, u;
vector<int> v;

/**
 * 用dfs枚举每个位置上可能的数字，枚举完最后一位的时候把整个数组输出。
 */

void dfs() {
    if (v.size() == u) {
        for (auto i: v)cout << i << " ";
        cout << endl;
        return;
    }
    for (int i = 1; i <= n; i++) {
        if (f[i] != 0) {
            f[i]--;
            v.push_back(i);
            dfs();
            v.pop_back();
            f[i]++;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> f[i];
        u += f[i];
    }
    dfs();
    return 0;
}
