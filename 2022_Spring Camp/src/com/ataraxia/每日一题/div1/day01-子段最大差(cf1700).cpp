#include<cstdio>
#include<cstring>
#include<cmath>
#include<iostream>
#include<algorithm>
using namespace std;

// 单调栈

typedef long long ll;
const int MAXN = 5e5+7, INF = 0x3f3f3f3f;
ll a[MAXN], st[MAXN];
ll n;
void solve() {
	ll tot1 = 0, tot2 = 0, top = 0;
	//作为最小的数 
	for (int i = 1; i <= n + 1; i++) {
		while (top > 0 && a[st[top-1]] >= a[i]) {
			tot1 += (st[top-1]-st[top-2])*(i-st[top-1])*a[st[top-1]];
			top--;
		}
		st[top++] = i;
	}
	//作为最大的数 
	top = 0;
	a[n+1] = INF; 
	for (int i = 1; i <= n + 1; i++) {
		while (top > 0 && a[st[top-1]] <= a[i]) {
			tot2 += (st[top-1]-st[top-2])*(i-st[top-1])*a[st[top-1]];
			top--;
		}
		st[top++] = i;
	}
	printf("%lld\n", tot2 - tot1);
}
int main() {
	scanf("%lld", &n);
	for(int i = 1; i <= n; i++)
		scanf("%lld", &a[i]);
	solve();
	return 0;
}