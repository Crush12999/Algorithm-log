#include <bits/stdc++.h>

#define endl '\n';
using namespace std;
typedef long long ll;

/**
 * 准备两个map容器，一个p记录篮子里的果冻的价格，t记录口感。
 * 因为map是键值对形式存储，我们对于p，可以以价格为key，口感为val；
 * t可以以口感为key，价格为val。
 * 这样记的目的是，我们不论是2操作还是3操作，都可以同时从两个容器里把目标果冻删去。
 * 最后只要遍历p里的key，并计算总和即可。（用map也可以判断当前篮子里是否有口感或价格一样的果冻）
 * 说一下这里map用到的几个函数：
 * erase（a）：可以删除map里以a为key的键值对。（这里用作2，3操作）
 * count（a）：可以判断map中是否有以a为key的键值对。（这里用作判重）
 * begin()：是map 的首元素的迭代器（可以把它理解为指针）
 */

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n, ans = 0;
    cin >> n;
    map<int, int> p, t;
    while (n--) {
        int st;
        cin >> st;
        if (st == 1) {
            int a, b;
            cin >> a >> b;
            if (p.count(a) == 0 && t.count(b) == 0) {
                p[a] = b;
                t[b] = a;
            }
        } else if (st == 2) {
            t.erase(p.begin()->second);
            p.erase(p.begin());
        } else if (st == 3) {
            p.erase(t.begin()->second);
            t.erase(t.begin());
        }
    }
    ll sum = 0;
    for (auto i: p)sum += i.first;
    cout << sum << endl;
    return 0;
}
