#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

/**
 * 我们可以在0~5的区间内二分枚举p（当然是以浮点数的形式），浮点二分和一般的二分结束条件不太一样，
 * 一般的结束条件是l<r，但由于这是浮点数，显然是不适用的，
 * 浮点二分的结束条件一般是r-l>（与标准答案最多能相差的精度），在这题就是r-l>1e(-6)。
 * 然后就是用枚举的p来计算。提示里说了：第 k 个月偿还的金额只相当于 100/(1+p)^k 元的初始金额。
 * 那么这就是个等比数列的前n项和了，计算一共k个月（0~k)偿还的金额是否等于n即可。
 * 如果少了说明p小了，如果多了说明p大了。
 */

double check(double mid, int k, int m) {
    double res = 0, p = 1 + mid;
    for (int i = 1; i <= k; i++) {
        res += m / p;
        p *= (1 + mid);
    }
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    ll n, m, k;
    cin >> n >> m >> k;
    double l = 0, r = 5;
    while (r - l >= 1e-8) {
        double mid = (r + l) / 2;
        double money = check(mid, k, m);
        if (money > (double) n)l = mid;
        else r = mid;
    }
    cout << fixed << setprecision(6) << l << endl;
    return 0;
}
