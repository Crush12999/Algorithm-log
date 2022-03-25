#include <bits/stdc++.h>

#define endl '\n';
typedef long long ll;
using namespace std;

/**
 * 想要有利的情况下自己胜出，也就是说选出的数都是自己有的，
 * 而且自己在第一个清空前不能有别人比自己先清空。
 * 意思就是自己不能包含别人的全部数：别人不能是自己的子集。
 * 比如自己是1 3 5，别人是3 5，那么最好的情况也是别人和我一起清空，这样两边都不能赢，
 * 如果自己是1 3 5，别人是3 4，那我只要不删4就行了，这样就是我先赢。
 * 那么我们就记录每个玩家的牌的情况，然后判断我们的牌是否完全包含其它玩家的牌，
 * 如果有一个完全包含那我们就不能赢。
 */

int mp[101][101];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int t, n;
    cin >> t;
    for (int i = 0; i < t; i++) {
        cin >> n;
        for (int j = 0; j < n; j++) {
            int num;
            cin >> num;
            mp[i][num] = 1;
        }
    }
    for (int i = 0; i < t; i++) {
        bool flag = true;
        for (int j = 0; j < t; j++) {
            if (i == j)continue;
            bool st = false;
            for (int k = 0; k <= 100; k++) {
                if (mp[i][k] < mp[j][k]) {
                    st = true;
                    break;
                }
            }
            if (!st) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            cout << "NO" << endl;
        } else cout << "YES" << endl;

    }
    return 0;
}
