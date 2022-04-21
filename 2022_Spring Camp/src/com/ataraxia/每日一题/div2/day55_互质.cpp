#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int N = 100500;
bool mp[N], prime[N], st[N];
int maxp[N];

/**
 * 首先，要互质说明不能有一样的因数，那么我们可以把所有的数先分解因数，然后再从1枚举到m，
 * 只要能被这些因数整除的就不是合格的k，我们记录下所有合格k的数量然后从小到大输出即可。
 * 最朴素的暴力做法了，我们想办法优化一下它。
 * 实际上我们不用求出所有的因数的，大的因数可以经由小的因数得到，而且如果一个数不能被小因数整除，
 * 那么经由小因数得到的大因数肯定也无法整除这个数，比如2无法整除9，那么经由2得到的4 6 8等肯定也无法整除。
 * 所有我们不用求所有的因数，而是去求质因数（因为质因数是无法通过小因数得到的，它是质数啊），
 * 那么我们就把所有的数分解质因数，然后通过线性筛，筛掉所有不合格的k即可。
 * 如果当前数已经是质数了就不用分解质因数直接线性筛即可。
 */
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n, m, x;
    cin >> n >> m;
    maxp[1] = 1;
    for (ll i = 2; i <= N; i++) {
        if (st[i])continue;
        for (ll j = i * 2; j <= N; j += i) {
            st[j] = true;
            maxp[j] = i;
        }
        maxp[i] = i;
    }
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        if (mp[x])continue;
        mp[x] = true;
        while (x != 1) {
            prime[maxp[x]] = 1;
            x /= maxp[x];
        }
    }
    vector<int> k;
    k.push_back(1);
    for (int i = 2; i <= m; i++) {
        if (prime[i] && !st[i])
            for (int j = i; j <= m; j += i)
                mp[j] = 1;
    }
    for (int i = 2; i <= m; i++)
        if (!mp[i])
            k.push_back(i);
    cout << k.size() << "\n";
    for (auto i: k) {
        cout << i << "\n";
    }
    return 0;
}
