#include<iostream>
using namespace std;
#include<vector>
#include<algorithm>
#include<math.h>
#include<set>
#include<numeric>
#include<string>
#include<string.h>
#include<iterator>
#include<map>
#include<unordered_map>
#include<stack>
#include<list>
#include<queue>
#include<iomanip>

#define endl '\n';
typedef long long ll;
typedef pair<ll, ll>PII;
const int N = 100010;
ll a[N], f[4 * N];

ll gcd(ll a, ll b)
{
    return b == 0 ? a : gcd(b, a % b);
}

void buildtree(ll k, ll l, ll r)
{
    if (l == r)
    {
        f[k] = a[l];
        return;
    }
    int m = (l + r) / 2;
    buildtree(k + k, l, m);
    buildtree(k + k + 1, m + 1, r);
    f[k] = gcd(f[k + k], f[k + k + 1]);
}

ll calc(ll k, ll l, ll r, ll x, ll y)
{
    if (l == x&&r==y)return f[k];

    int m = (l + r) / 2;
    if (y <= m)return calc(k + k, l, m, x, y);
    else
        if (x > m)return calc(k + k + 1, m + 1, r, x, y);
        else
        {
            return gcd(calc(k + k, l, m, x, m), calc(k + k + 1, m + 1, r, m + 1, y));
        }
}

int main()
{
    cin.sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, t;
    cin >> n;
    vector<ll>v(n + 1);
    for (int i = 1; i <= n; i++)cin >> v[i];
    for (int i = 1; i <= n; i++)
    {
        a[i] = abs(v[i] - v[i - 1]);
    }

    buildtree(1, 1, n);
    ll l = 1, r = 1, len = 1, ans = 1;
    while (r <= n)
    {
        ll num = calc(1, 1, n, l, r);
        if (num > 1)r++;
        else l++;
        while (l > r)r++;
        ans = l;
        while (num>1&&ans <= n && ans > 1 && v[ans] % num == v[ans - 1] % num)
        {
            ans--;
        }
        if (r - ans > len)
        {
            len = r - ans;
        }
    }

    cout << len;
    return 0;
}
