#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
int n;
unordered_map<int, int> c;
int a[200001];
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
    // x: 出现次数最多的出现几次, l: 长度
    int x = 0, l = 0;
    for (auto itr : c) {
        if (itr.second > x)
            x = itr.second, l = 0;
        if (itr.second == x)
            a[++l] = itr.first;
    }
    sort(a + 1, a + l + 1);
    for (int i = 1; i <= l; i++) {
        cout << a[i] << " ";
    }
    cout << "\n";
    return 0;
}
