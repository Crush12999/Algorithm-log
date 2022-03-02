#include <algorithm>
#include <iostream>
using namespace std;

typedef long long ll;

const int N = 100010;
int a[N];
ll n, k, ans;

bool check(ll x, ll cnt) {
    int p = 1;
    while (p <= n) {
        if (a[p] >= x) {
            break;
        }
        cnt -= x - a[p];
        if (cnt < 0) {
            return false;
        }
        p++;
    }
    return true;
}

int main() {
    scanf("%lld%lld", &n, &k);

    for (int i = 1; i <= n; i++) {
        scanf("%d", &a[i]);
    }
    
    sort(a + 1, a + n + 1);
    
    ll l = a[1], r = a[n] + k;
    while (l <= r) {
        ll mid = (l + r) >> 1;
        if (check(mid, k)) {
            ans = mid;
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    cout << ans;
    return 0;
}