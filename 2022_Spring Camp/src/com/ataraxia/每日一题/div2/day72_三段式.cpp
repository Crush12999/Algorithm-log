#include<bits/stdc++.h>

using namespace std;
#define int long long
const int N = 1e6 + 100;
int a[N];

signed main() {
    int n, sum = 0, aa = 0, ans = 0;
    scanf("%lld", &n);
    for (int i = 1; i <= n; i++) {
        scanf("%lld", &a[i]);
        sum += a[i];
    }
    int p = sum / 3;
    sum = 0;
    for (int i = 1; i < n; i++) {
        sum += a[i];
        if (sum == p * 2) ans += aa;
        if (sum == p) aa++;
    }
    printf("%lld", ans);
}