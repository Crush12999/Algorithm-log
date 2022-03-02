#include <iostream>
using namespace std;

int n;
char mp[110][110];

int main() {
	
	cin >> n;
	
	for (int i = 1; i <= n - i + 1; i++) {
		for (int j = i; j <= n - i + 1; j++) {
			if (i & 1) {
				mp[i][j] = mp[j][i] = '+';
				mp[n - i + 1][j] = mp[j][n - i + 1] = '+';
			} else {
				mp[i][j] = mp[j][i] = '.';
				mp[n - i + 1][j] = mp[j][n - i + 1] = '.';
			}
		}
	}
	
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cout << mp[i][j];
		}
		cout << "\n";
	}
	
    return 0;
}