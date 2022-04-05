#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int, char> PII;

/**
 * 只有所处一条横线上的人才有可能相撞（y轴相同）。
 * 我们把所有的人以y轴区分，用一个哈希表，以y为key来存。
 * 用一个set容器做val（普通数组也可以，但要自己排序，我比较懒就用个能自动排序的容器），
 * set存储的是一个数对，first是x轴，second是他们的方向。
 * 要相撞，除了是一条直线上，还需要方向相反。
 * 但是必须是排在前面的人往右走，排在后面的人往左走才可以。
 * 如果排在前面的人往左走，排在前面的人往后走，那么这俩个人只会离得越来越远，更别提相撞了。
 * 所以我们把人根据y轴区分后，还要把他们以x排序，x小的排在前面，
 * 然后我们遍历一下y相同的人，只要前面有一个是向右走，且后面有一个向左走的，就说明他们会相撞，
 * 直接输出yes后结束程序即可。如果遍历所有的y轴都没有相撞的，就输出NO。
 */

inline int read() {
    int x = 0;
    char ch = getchar();
    while (ch < '0' || ch > '9') ch = getchar();
    while (ch >= '0' && ch <= '9') x = (x << 3) + (x << 1) + ch - '0', ch = getchar();
    return x;
}

void write(int x) {
    if (x > 9) write(x / 10);
    putchar(x % 10 | '0');
}

bool operator<(PII a, PII b) {
    return a.first < b.first;
}

int main() {
    int n;
    n = read();
    unordered_map<int, set<PII>> mymap;
    vector<pair<int, int>> v(n);
    for (int i = 0; i < n; i++) {
        v[i].first = read(), v[i].second = read();
    }
    string str;
    cin >> str;
    for (int i = 0; i < n; i++) {
        mymap[v[i].second].insert({v[i].first, str[i]});
    }
    bool flag = false;
    for (auto i: mymap) {
        bool st = false;
        for (auto j: i.second) {
            if (j.second == 'R')st = true;
            else if (st && j.second == 'L') {
                flag = true;
                break;
            }
        }
        if (flag)break;
    }
    if (flag) {
        cout << "Yes" << endl;
    } else cout << "No" << endl;

    return 0;
}
