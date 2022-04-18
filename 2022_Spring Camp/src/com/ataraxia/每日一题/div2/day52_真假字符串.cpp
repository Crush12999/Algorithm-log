#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

/**
 * abacaba 删除第二个字符 b 可以得到字符串 S1, 并且删除第一个字符 b 可以得到字符串 S2。
 * 如果题目说的，有一个字符串s可以通过删除一个字符得到s1和s2，
 * 那说明要么s1和s2相等(s删除的地方一样)，要么说明s1和s2有一处地方不一样（s删除的地方不一样），
 * 即我们可以把题目转化成：s1和s2是否可以最多删除一个字符后相等。
 * 我们先遍历一下两个字符串，找第一个不相同的地方，如果没有，说了s1和s2相同，我们直接输出1。
 * 如果有不相同的地方，则要分两种情况讨论了：
 * 1、我们删掉s1的一个字符，然后继续比较s1和s2，如果找到下一处地方不一样，就删除s2的一个字符，
 * 经过这次删除后如果两个字符串相同了就是1，不然我们就看第二种情况。
 * 2、我们删掉s2的一个字符，然后继续比较s1和s2，如果找到下一处地方不一样，就删除s1的一个字符，
 * 经过这次删除后如果两个字符串相同了就是1，反之是0。
 */

bool dfs(string s1, string s2) {
    int n = s1.size(), l = 0, r = 0;
    bool st = true;
    while (l < n && r < n) {
        if (s1[l] != s2[r]) {
            if (st) {
                l++;
                st = false;
            } else {
                return false;
            }
        } else {
            l++, r++;
        }
    }
    if (l < n) {
        return false;
    }
    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    string s1, s2;
    cin >> s1 >> s2;
    int n = s1.size(), ans = -1;
    for (int i = 0; i < n; i++) {
        if (s1[i] != s2[i]) {
            ans = i;
            break;
        }
    }
    if (ans == -1) {
        cout << 1 << "\n";
    } else {
        string str1 = s1, str2 = s2;
        str1.erase(ans, 1);
        str2.erase(ans, 1);
        if (dfs(s2, str1) || dfs(s1, str2)) {
            cout << 1 << "\n";
        } else cout << 0 << "\n";
    }
    return 0;
}
