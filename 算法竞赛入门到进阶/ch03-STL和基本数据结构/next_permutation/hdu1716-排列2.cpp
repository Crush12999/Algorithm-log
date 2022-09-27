// hdu1716 排列2
#include <bits/stdc++.h>

using namespace std;
int a[5];

int main() {
    cin >> a[1] >> a[2] >> a[3] >> a[4];
    while (true) {
        if (a[1] + a[2] + a[3] + a[4] == 0) break;
        sort(a + 1, a + 5);    //排序
        int prev = a[1];
        if (a[1]) {
            cout << a[1] << a[2] << a[3] << a[4];
        }
        while (next_permutation(a + 1, a + 5)) {
            if (a[1] == prev && a[1]) {
                cout << " " << a[1] << a[2] << a[3] << a[4];
            } else {
                if (a[1]) {
                    if (prev) {
                        cout << "\n";    // 换行
                    }
                    cout << a[1] << a[2] << a[3] << a[4];
                }
                prev = a[1];
            }
        }
        cout << "\n";
        cin >> a[1] >> a[2] >> a[3] >> a[4]; // 仅仅有下次不退出才换行
        if (a[1] + a[2] + a[3] + a[4] != 0) {
            cout << "\n";
        }
    }
    return 0;
}