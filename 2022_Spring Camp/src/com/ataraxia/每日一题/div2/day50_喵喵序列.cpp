#include<bits/stdc++.h>

using namespace std;
#define rep(i, a, n) for(int i=a;i<n;i++)
#define per(i, a, n) for(int i=n-1;i>=a;i--)
#define pb push_back
#define mp make_pair
#define all(x) (x).begin(), (x).end()
#define fi first
#define se second
#define SZ(x) ((int)(x).size()
typedef vector<int> VI;
typedef long long ll;
typedef pair<int, int> PII;
typedef double db;
mt19937 mrand(random_device{}());
const ll mod = 1000000007;
int rnd(int x) { return mrand() % x; }
//ll powmod(ll a,ll b){ll res=1; a%=mod; assert(b>=O);}
ll gcd(ll a, ll b) { return b ? gcd(b, a % b) : a; }

inline int lowbit(int x) {
	return x & (-x);
}

const int N = 3e4 + 5;
ll a[N], b[N], ans;
int n, t[N], sm[N];

inline void update(int pos, int val) {
	while (pos <= n) {
		t[pos] += val;
		pos += lowbit(pos);
	}
	return;
}

inline ll query(int pos) {
	ll sum = 0;
	while (pos > 0) {
		sum += t[pos];
		pos -= lowbit(pos);
	}
	return sum;
}

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%lld", &a[i]);
		b[i] = a[i];
	}
	sort(b + 1, b + 1 + n);
	int l = unique(b + 1, b + 1 + n) - b;
	for (int i = 1; i <= n; i++) {
		a[i] = lower_bound(b + 1, b + l, a[i]) - b;
		sm[i] = query(a[i] - 1);
		update(a[i], 1);
	}
	memset(t, 0, sizeof(t));
	for (int i = n; i >= 1; i--) {
		ans += (ll) (n - i - query(a[i])) * (ll) sm[i];
		update(a[i], 1);
	}
	printf("%lld", ans);
}