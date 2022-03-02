#include <iostream>
#include <cstdio>
#include <cstring>
using namespace std;

const int maxn = 100007;
int n;
int s[maxn], vis[maxn];

int main() {
	scanf("%d", &n);
	memset(vis, -1, sizeof(vis));
	vis[0] = 0;
	for (int i = 1; i <= n; i++) {
		scanf("%d", &s[i]);
		s[i] = (s[i-1] + s[i]) % n;
		if (vis[s[i]] == -1) {
			vis[s[i]] = i;
		} else {
			printf("%d\n", i - vis[s[i]]);
			for (int j = vis[s[i]] + 1; j <= i; j++) {
				printf("%d ", j);
			}
			break;
		}
	}
	
	return 0;
}

