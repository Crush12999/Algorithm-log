#include <bits/stdc++.h>

#define endl '\n';

using namespace std;
typedef long long ll;

bool cmp(int a, int b) {
    return a > b;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n, k;
    cin >> n >> k;
    vector<int> v(n);
    for (int i = 0; i < n; i++)
        cin >> v[i];
    sort(v.begin(), v.end(), cmp);
    int res = 1;
    for (int i = 0; i < n - 1; i++) {
        if (v[i] - v[i + 1] <= k)res++;
        else break;
    }
    cout << res << endl;
    return 0;
}
