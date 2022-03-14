#include <bits/stdc++.h>

using namespace std;

/**
 * 这题可以直接计数做，我这里使用前缀和节省点细节操作。
 * 先选一个要记录的颜色，我这里选择的是‘W’，然后遍历数组计算前缀和，
 * 遇到当前格子为‘W’时前缀和++。当遍历到的位置大于3时，我们就可以回头看之前的位置了，
 * 如果当前位置的前缀和减去往前数第三个位置的前缀和的差值等于3时，
 * 说明这中间连着的都是’W’，不满足情况直接输出0。如果差值为0，
 * 说明这段路上都没有‘W’，都是’B‘，这也是不符合条件的，输出0。
 * 我们先一行行的遍历，如果没有异样，那我们就再一列列来。
 * 如果也没有问题那就输出1。
 */

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n;
    cin >> n;
    vector<int> s(n + 1);
    vector<vector<char>> v(n + 1, vector<char>(n + 1));
    string str;

    for (int i = 1; i <= n; i++) {
        cin >> str;
        for (int j = 1; j <= n; j++) {
            v[i][j] = str[j - 1];
            s[j] = s[j - 1];
            if (str[j - 1] == 'W')s[j] += 1;
            if (j >= 4 && (s[j] == s[j - 3] || s[j] - s[j - 3] == 3)) {
                cout << 0 << endl;
                return 0;
            }
        }
        if (s[n] != n / 2) {
            cout << 0 << endl;
            return 0;
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            s[j] = s[j - 1];
            if (v[j][i] == 'W')s[j] += 1;
            if (j >= 4 && (s[j] == s[j - 3] || s[j] - s[j - 3] == 3)) {
                cout << 0 << endl;
                return 0;
            }
        }
        if (s[n] != n / 2) {
            cout << 0 << endl;
            return 0;
        }
    }
    cout << 1 << endl;
    return 0;
}
