#include<cstdio>
#include<iostream>
#include<algorithm>
using namespace std;
typedef long long ll;

// i: 第i级结束
// j: 到第i级的时候总共走了j次2阶

ll f[100][3];
ll n, ans;

int main() {
	cin >> n;
	
	f[1][0] = f[2][1] = f[2][0] = 1;
	
	for (int i = 3; i <= n; i++) {
		for (int j = 0; j < 3; j++) {
			f[i][0] += f[i-1][j];
		}
		f[i][1] += f[i-2][0];
		f[i][2] += f[i-2][1];
	}
	
	for (int j = 0; j < 3; j++) {
		ans += f[n][j];
	}
	
	cout << ans << endl;
	
	return 0;
}