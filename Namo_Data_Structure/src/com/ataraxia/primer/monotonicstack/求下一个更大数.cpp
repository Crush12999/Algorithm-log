//
// http://oj.daimayuan.top/course/7/problem/506
// 用栈顶元素最小的单调栈
//

#include <bits/stdc++.h>

using namespace std;

// s存的是数字对应的下标
int n, s[200010], a[200010], top = 0, ans[200010];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) {
        scanf("%d", &a[i]);
    }
    for (int i = 1; i <= n; i ++) {
        while (top && a[i] > a[s[top]]) {
            ans[s[top]] = i;
            --top;
        }
        s[++top] = i;
    }
    for (int i = 1; i <= top; i++) {
        ans[s[i]] = 0;
    }
    for (int i = 1; i <= n; i++) {
        printf("%d ", ans[i]);
    }
}