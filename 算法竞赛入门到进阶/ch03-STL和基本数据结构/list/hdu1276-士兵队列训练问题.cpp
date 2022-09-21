//
// hdu1276 士兵队列训练问题
//
#include <bits/stdc++.h>
using namespace std;
int main() {
    int t, n;
    cin >> t;
    while (t--) {
        cin >> n;
        int k = 2;
        list<int> myList;
        list<int>::iterator iter;
        for (int i = 1; i <= n; i++) {
            myList.push_back(i);
        }
        while (myList.size() > 3) {
            int num = 1;
            for (iter = myList.begin(); iter != myList.end(); ) {
                if (num++ % k == 0) {
                    iter = myList.erase(iter);
                } else {
                    iter++;
                }
            }
            // 1 至 2 报数，1 至 3 报数
            k = (k == 2) ? 3 : 2;
        }
        for (iter = myList.begin(); iter != myList.end(); iter++) {
            if (iter != myList.begin()) {
                cout << " ";
            }
            cout << *iter;
        }
        cout << "\n";
    }
    return 0;
}