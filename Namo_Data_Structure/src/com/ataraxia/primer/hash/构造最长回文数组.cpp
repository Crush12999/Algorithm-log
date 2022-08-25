#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
int n, a[200001];
unordered_map<int, int> c;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cin >> n;
    for (int i = 1; i <= n; i++) {
        int x;
        cin >> x;
        c[x]++;
    }
    // x: 每个数字出现次数的偶数部分的和
    int x = 0;
    // 有没有出现奇数次
    bool odd = false;
    for (auto itr : c) {
        // 判断是不是奇数次
        if (itr.second & 1)
            odd = true;
        x += itr.second / 2 * 2;
    }
    if (odd)
        ++x;
    cout << x << "\n";
    return 0;
}
