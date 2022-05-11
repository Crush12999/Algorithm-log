#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int N = 2e5 + 50;
ll a[N], f[4 * N];

/**
 * 他要我们把这个01序列变成非递减序列，说人话就是把这个01序列变成前面全是0后面全是1的形状，问变成这样要几步。
 * 那我们可以枚举每一个位置，把这个位置之前的为1的点都变成0，之后的为0的点都变成1，
 * 看哪一个位置要进行的操作最少，输出这个最少的次数。
 * 至于怎么获得这个位置之前的1和之后的0的个数，我们可以通过计算前缀和来得到。
 * 拿样例来说，假设我们枚举到第三个位置，i=2，那么i-1位置的前缀和是1，说明前面的位置有1个1，
 * 然后i+1位置到末尾的区间和为2，但是i+1位置到末尾有3个位置，也就说后面出现了一个0，
 * 那么这个位置一共修改两次就可以把整个序列变的有序了。
 */

void revise(int k, int l, int r, int x) {
    if (l == r) {
        f[k] += 1;
        return;
    }
    int m = (l + r) / 2;
    if (x <= m)revise(k + k, l, m, x);
    else revise(k + k + 1, m + 1, r, x);
    f[k] = f[k + k] + f[k + k + 1];
}

int quire(int k, int l, int r, int x, int y) {
    if (l == x && y == r) {
        return f[k];
    }
    int m = (l + r) / 2;
    if (y <= m)return quire(k + k, l, m, x, y);
    else if (x > m)return quire(k + k + 1, m + 1, r, x, y);
    else return quire(k + k, l, m, x, m) + quire(k + k + 1, m + 1, r, m + 1, y);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n;
    string s;
    cin >> n >> s;
    if (n == 1) {
        cout << 0 << "\n";
        return 0;
    }
    vector<int> sum(n);
    sum[0] = s[0] - '0';
    for (int i = 1; i < n; i++)sum[i] = sum[i - 1] + s[i] - '0';
    int res = 1e9;
    for (int i = 0; i < n; i++) {
        if (i == 0)res = min(res, n - (i + 1) - (sum[n - 1] - sum[0]));
        else if (i == n - 1)res = min(res, sum[i - 1]);
        else res = min(res, sum[i - 1] + n - (i + 1) - (sum[n - 1] - sum[i]));
    }
    cout << res << "\n";
    return 0;
}
