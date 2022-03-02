#include <iostream>

using namespace std;

const int maxn = 1e6 + 7;
int a[maxn], pos[maxn], s[maxn], n, q;

// cf #576(Div 2) - D.Welfare State
int main() {
	
	ios::sync_with_stdio(false);
	
	cin >> n >> q;
	
	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}
	
	for (int i = 1; i <= q; i++) {
		int op, x, y;
		cin >> op;
		if (op == 1) {
			cin >> x >> y;
			a[x] = y;
			pos[x] = i;
		} else {
			cin >> s[i];
		}
	}
	for (int i = q; i >= 1; i--) {
		s[i] = max(s[i], s[i+1]);
	}
	
	for (int i = 1; i <= n; i++) {
		cout << max(a[i], s[pos[i]+1]) << " ";
	}
	
	return 0;
}

