#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int N = 2e6 + 50;
int f[100000], a[N];
unordered_map<int, int> mp;

/**
 * 直接暴力bfs搜就可以，题目说了就4位数，我们每次修改4个位置上的数，用0~9替换，
 * 替换后判断是否是质数即可，然后计算变换到b一共需要几步。
 * 为了防止t，我们可以先把所有四位数的质数都求出来，这样修改一个位置上的数后，
 * 就可以通过直接判断一个数是否在质数集里来判断它是不是质数了，
 * 顺便记录一下已经变换过的数，这样下次遇到这个数的时候我们直接不理他即可。
 */

void getPrime() {
    for (int i = 1000; i <= 9999; i++) {
        bool flag = true;
        for (int j = 2; j <= i / j; j++) {
            if (i % j == 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            mp[i] = 1;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int t;
    cin >> t;
    getPrime();
    while (t--) {
        int a, b;
        cin >> a >> b;
        if (a == b) {
            cout << 0 << "\n";
            continue;
        }
        queue<int> q;
        q.push(a);
        memset(f, 0, sizeof f);

        int res = 1;
        bool flag = false;
        while (!q.empty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int num = q.front();
                q.pop();
                for (int j = 10; j <= 10000; j *= 10) {
                    int l = num / j, r = num % (j / 10);
                    for (int k = 0; k <= 9; k++) {
                        int ans = l * j + k * (j / 10) + r;
                        if (ans == b) {
                            flag = true;
                            break;
                        }
                        if (!f[ans] && mp[ans]) {
                            f[ans] = 1;
                            q.push(ans);
                        }
                    }
                    if (flag) break;
                }
                if (flag) break;
            }
            if (flag) break;
            res++;
        }
        cout << res << "\n";

    }
    return 0;
}
