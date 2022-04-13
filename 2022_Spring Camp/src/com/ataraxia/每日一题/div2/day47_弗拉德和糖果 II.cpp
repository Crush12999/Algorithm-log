#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

/**
 * 这是一道思维题，我们只用看最大值与其他值的和的关系就行：
 * 当最大值大于其它值的和+1时，哪怕我们吃一口其它的糖，再吃一口最大数量的糖，
 * 最后也会剩下最大值的种类的糖，这样就必然要连着吃两个一样，所以要输出NO。
 * 当最大值等于其它值的和+1时，我们只要吃一口最大数量的糖，再吃一口其它数量的糖即可。
 * 这样就能正好吃完。输出YES。
 * 当最大值小于其它值的和+1时，我们可以先把其他数量的糖果内部消化到总和和最大值数量相等，
 * 这样就是第二种情况了。输出YES。
 */

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n;
    ll sum = 0, mx = 0, num;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> num;
        if (mx < num) {
            sum += mx;
            mx = num;
        } else sum += num;
    }
    if ((n == 1 && mx == 1) || mx <= sum + 1) {
        puts("YES");
    } else {
        puts("NO");
    }
    return 0;
}
