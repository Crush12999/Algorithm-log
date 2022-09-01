//
// http://oj.daimayuan.top/course/7/problem/495
//

#include <bits/stdc++.h>
using namespace std;

int n;
priority_queue<int> a, b;

int main() {
    scanf("%d", &n);
    int x;
    scanf("%d", &x);
    a.push(x);
    printf("%d ", a.top());
    for (int i = 1; i <= n / 2; i++) {
        int x, y, z = a.top();
        scanf("%d%d", &x, &y);
        if (x < z) {
            a.push(x);
        } else {
            b.push(-x);
        }
        if (y < z) {
            a.push(y);
        } else {
            b.push(-y);
        }
        if (a.size() - b.size() == 3) {
            b.push(-a.top());
            a.pop();
        } else {
            if (b.size() - a.size() == 1) {
                a.push(-b.top());
                b.pop();
            }
        }
        printf("%d ", a.top());
    }
}