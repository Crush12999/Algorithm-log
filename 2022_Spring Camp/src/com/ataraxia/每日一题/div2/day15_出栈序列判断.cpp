#include <bits/stdc++.h>
using namespace std;

const int N = 1e6 + 7;
int a[N], s[N];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
    }

    int top = 0, j = 1;
    for (int i = 1; i <= n; i++) {
        cout << "push " << i << "\n";
        s[++top] = i;
        while (top && a[j] == s[top] && j <= n) {
            j++;
            top--;
            cout << "pop\n";
        }
    }

    while (top) {
        cout << "pop\n";
        top--;
    }


    return 0;
}
