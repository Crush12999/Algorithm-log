#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll, ll> PII;

inline int read() {
    int x = 0;
    char ch = getchar();
    while (ch < '0' || ch > '9') ch = getchar();
    while (ch >= '0' && ch <= '9') x = (x << 3) + (x << 1) + ch - '0', ch = getchar();
    return x;
}

inline void write(int x) {
    if (x > 9) write(x / 10);
    putchar(x % 10 | '0');
}

int main() {
    int n;
    n = read();
    map<ll, int> alice, bob;
    ll sum = 0, len = 0;
    vector<ll> v(n);
    for (int i = 0; i < n; i++) {
        v[i] = read();
        sum += v[i];
        alice[sum] = i + 1;
    }
    sum = 0;
    for (int i = n - 1; i >= 0; i--) {
        sum += v[i];
        if (alice[sum] != 0 && alice[sum] + n - i <= n) {
            len = alice[sum] + n - i;
        }
    }
    write(len);

    return 0;
}
